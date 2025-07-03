package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Category;
import com.example.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

	public List<Expense> findExpenseByUserId(int userId);
	
	@Query("select e from Expense e where e.userId = ?1 order by e.date desc,e.expenseId desc limit 3 ")
	public List<Expense> findRecentExpenseByUserId(int userId);
	
	@Query("SELECT e.category,sum(amount) as amount FROM Expense e WHERE e.userId =?1 group by category")
	public List<Category> findCategoriesAmountByUserId(int userId);
	
	@Query("SELECT e.category,sum(amount) as amount FROM Expense e WHERE e.userId =?1 and EXTRACT(MONTH FROM date) = ?2  group by category")
	public List<Category> findCategoriesMonthAmountByUserId(int userId,int month );
	
	
	@Query("SELECT e FROM Expense e WHERE userId = ?1 AND EXTRACT(MONTH FROM date) = ?2 order by date desc")
			List<Expense> findExpenseForMonthByUserId(int userId, int month);
	
}
