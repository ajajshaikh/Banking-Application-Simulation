package com.ajaj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "receiver")
	private String receiver;
	@Column(name = "sender")
	private String sender;
	@Column(name = "amount")
	private int amount;

	public Transaction() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getreceiver() {
		return receiver;
	}

	public void setreceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getsender() {
		return sender;
	}

	public void setsender(String sender) {
		this.sender = sender;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
