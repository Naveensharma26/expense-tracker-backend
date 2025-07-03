package com.example.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "expense_id")
	int expenseId;
	
	@Column(name ="user_id")
	int userId;
	
	
	String category;

	String description;
	
	long amount;
	
	LocalDate date;
}
