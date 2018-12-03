package com.ajaj.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ajaj.config.CustomAuth;
import com.ajaj.controller.Users;
import com.ajaj.model.Transaction;
import com.ajaj.model.User;
import com.ajaj.repository.*;
import com.ajaj.services.TransactionService;

@Controller
public class Applicationcontroller {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {

		return new ModelAndView("register", "command", new Users());

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("abc") Users abc, Model model) {
		User user = new User();
		user.setUsername(abc.username);
		user.setPassword(abc.password);
		user.setBalance(10000);
		System.out.println(abc.username);
		if (userRepository.findByUsername(abc.username).isEmpty()) {
			if (userRepository.save(user) != null)
				;
			System.out.println("added to db!");
			return "login";
		} else {
			model.addAttribute("error", "Invalid credentials.");
			return "register";
		}

	}

	@RequestMapping("/login")
	public String login(Principal principal) {
		if (principal == null) {
			// logger.info("entered login page");
			return "login";

		} else
			return "redirect:/home";
	}

	@RequestMapping("/login-failure")
	public String loginFail() {
		return "login-failure";
	}

	@RequestMapping(value = { "/", "/home" })
	public String home() {
		return "redirect:/users/" + CustomAuth.username;
	}

	@RequestMapping(value = { "/users/{uname}" })
	public String home(@PathVariable String uname, Model model) {
		String username = uname.toUpperCase();

		model.addAttribute("name", username);
		return "home";
	}

	@RequestMapping(value = "/view-balance")
	public String showbalance(Model model, Principal principal) {
		List<User> usersa = new ArrayList<User>();
		usersa = userRepository.findByUsername(principal.getName());
		int a = 0;
		for (User u : usersa) {
			a = u.getBalance();
		}
		model.addAttribute("balance", a);
		return "balance";
	}

	@GetMapping("/view-transactions")
	public String showAllidTransactions(HttpServletRequest request, Principal principal) {
		request.setAttribute("mode", "MODE_A");

		request.setAttribute("idtransactions", transactionService.showAllidTransactions(principal));
		return "viewtransaction";
	}

	@RequestMapping(value = "/newtransaction", method = RequestMethod.GET)
	public String newtransaction(HttpServletRequest request, Model model, Principal principal) {
		String susername = principal.getName();
		model.addAttribute("name", susername);
		return "transaction";
	}

	@RequestMapping(value = "/newtransaction", method = RequestMethod.POST)
	public String registerTransaction(@ModelAttribute("transaction") Transaction transaction,
			BindingResult bindingResult, HttpServletRequest request, Principal principal) {

		User senderuser1 = new User();
		User reciveruser1 = new User();
		List<User> users = new ArrayList<User>();
		List<User> reciverusers = new ArrayList<User>();
		users = userRepository.findByUsername(principal.getName());
		int sender = 0;
		for (User u : users) {
			senderuser1 = u;
			sender = u.getBalance();
		}
		reciverusers = userRepository.findByUsername(transaction.getreceiver());
		int receiver = 0;
		for (User u : reciverusers) {
			reciveruser1 = u;
			receiver = u.getBalance();
		}
		if (userRepository.findByUsername(transaction.getreceiver()).isEmpty()) {
			return "transactionfailure";
		} else if (sender >= transaction.getAmount()) {
			sender = sender - transaction.getAmount();
			receiver = receiver + transaction.getAmount();
			senderuser1.setBalance(sender);
			reciveruser1.setBalance(receiver);
			transactionRepository.save(transaction);
			return "home";
		} else {
			return "transactionbalancefailure";
		}

	}

	@RequestMapping("/forgot-password")
	public String forgotPassword() {
		return "forgot";
	}

	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
	public String forgotReply(@ModelAttribute("abc") Users abc, Model model) {
		if (userRepository.findByUsername(abc.username).isEmpty()) {
			model.addAttribute("reply", "No user is registered with this username");
			return "afterforgot";
		} else {
			model.addAttribute("reply", "Hi " + abc.username.toUpperCase()
					+ "! This method has not been implemented yet check again later.");
			return "afterforgot";
		}
	}

}
