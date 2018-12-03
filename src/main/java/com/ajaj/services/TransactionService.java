package com.ajaj.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ajaj.model.Transaction;
import com.ajaj.repository.TransactionRepository;
import com.ajaj.repository.UserRepository;

@Service
@Transactional
public class TransactionService {

	@Autowired
	UserRepository userRepository;

	private final TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<Transaction> showAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		for (Transaction transaction : transactionRepository.findAlls()) {

			transactions.add(transaction);
		}

		return transactions;
	}

	public List<Transaction> showAllidTransactions(Principal principal) {
		String name = principal.getName();

		List<Transaction> idtransactions = new ArrayList<Transaction>();
		for (Transaction idtransaction : transactionRepository.findAlls()) {
			if (idtransaction.getsender().equalsIgnoreCase(name)) {
				idtransactions.add(idtransaction);

			}
		}
		return idtransactions;
	}

}
