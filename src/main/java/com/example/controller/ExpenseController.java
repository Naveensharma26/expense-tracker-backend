package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.model.Expense;
import com.example.service.ExpenseService;

@RestController
@CrossOrigin
public class ExpenseController {

	@Autowired
	ExpenseService service;
	
	@GetMapping("/expenseByUserId/{userId}")
	public List<Expense> findExpenseByUserId(@PathVariable int userId){
		return service.findExpenseByUserId(userId);
	}
	
	@PostMapping("/expense")
	public Expense addExpense(@RequestBody Expense e) {
		return service.addExpense(e);
	}
	
	@GetMapping("/recentexpense/{userId}")
	public List<Expense> findRecentExpenseByUserId(@PathVariable int userId){
		return service.findRecentExpenseByUserId(userId);
	}
	
	@GetMapping("/countCatExpense/{userId}")
	public List<Category> findCategoriesAmountByUserId(@PathVariable int userId) {
		return service.findCategoriesAmountByUserId(userId);
	}
	
	@GetMapping("/countCatExpense/{userId}/{month}")
	public List<Category> findCategoriesMonthAmountByUserId(@PathVariable int userId,@PathVariable int month) {
		return service.findCategoriesMonthAmountByUserId(userId,month);
	}
	
	
	@GetMapping("/expenseByMonth/{userId}/{month}")
	public List<Expense> findExpenseForMonthByUserId(@PathVariable int userId,@PathVariable int month){
		return service.findExpenseForMonthByUserId(userId, month);
	}
	
	@DeleteMapping("/expense/{id}")
	public void deleteExpenseByExpenseId(@PathVariable int id) {
		service.deleteExpenseByExpenseId(id);
	}
	
	@GetMapping("/expense/{expId}")
	public Expense findExpenseById(@PathVariable int expId) {
		return service.findExpenseById(expId);
	}
	
	@PutMapping("/expense/{expId}")
	public void updateExpenseById(@PathVariable int expId,@RequestBody Expense e) {
		 service.updateExpenseById(expId,e);
	}
}
