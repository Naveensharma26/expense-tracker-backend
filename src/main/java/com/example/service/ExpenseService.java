package com.example.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.model.Expense;
import com.example.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository repo;
	
	public List<Expense> findExpenseByUserId(int userId){
		return repo.findExpenseByUserId(userId);
	}
	
	public Expense addExpense(Expense e) {
		return repo.save(e);
	}
	
	public Expense findExpenseById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void updateExpenseById(int id,Expense upd) {
		Expense e = findExpenseById(id);
		if(e!=null) {
			e.setAmount(upd.getAmount());
			e.setCategory(upd.getCategory());
			e.setDescription(upd.getDescription());
			e.setDate(upd.getDate());
			e.setUserId(upd.getUserId());
			repo.save(e);
		}
	}
	
	public List<Expense> findRecentExpenseByUserId(int userId){
		return repo.findRecentExpenseByUserId(userId);
	}
	
	public List<Category> findCategoriesAmountByUserId(int userId) {
		List<Category> categoryList =  repo.findCategoriesAmountByUserId(userId);
		return categoryList;
	}
	
	public List<Category> findCategoriesMonthAmountByUserId(int userId,int month) {
		List<Category> categoryList =  repo.findCategoriesMonthAmountByUserId(userId,month);
		return categoryList;
	}
	
	public List<Expense> findExpenseForMonthByUserId(int userId,int month){
		return repo.findExpenseForMonthByUserId(userId, month);
	}
	
	public void deleteExpenseByExpenseId(int id) {
		repo.deleteById(id);
	}
}
