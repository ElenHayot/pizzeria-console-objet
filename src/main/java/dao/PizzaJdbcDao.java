package dao;

import fr.pizzeria.console.Pizza;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.SQLException;

public class PizzaJdbcDao implements IPizzaDao {
	
	Connection connect;
	PreparedStatement statement;
	
	public PizzaJdbcDao() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (ClassNotFoundException e){
			e.getMessage();
		}
	}
	
	
	String jdbcUrl = "jdbc:mysql://localhost/bdd_pizzeria";
	
	
	
	@Override
	public Pizza[] findAllPizzas() {
		
		List<Pizza> listePizzas = new ArrayList<>();
		//InputStream input = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		//Properties property = new Properties();
		
		
		try{
			//connect = DriverManager.getConnection(property.getProperty("jdbcUrl"), property.getProperty("id"), property.getProperty("password"));
			//property.load(input);
			connect = DriverManager.getConnection(jdbcUrl, "root", "");
			statement = connect.prepareStatement("select * from pizzas");
			ResultSet result = statement.executeQuery();
			
			while(result.next()){
				String id = result.getString("ID");
				String name = result.getString("NAME");
				String category = result.getString("CATEGORY");
				Double price = result.getDouble("PRICE");
				
				listePizzas.add(new Pizza(id, name, category, price));
			}
			result.close();
			statement.close();
			connect.close();
			
		}catch(SQLException e){
			System.out.println("Problème de communication avec la base de données");
		}/*catch(IOException e){
			e.getMessage();
		}*/
		
		Pizza[] tab = new Pizza[listePizzas.size()];
		tab = listePizzas.toArray(tab);
		
		return tab;
		
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		try{
			connect = DriverManager.getConnection(jdbcUrl, "root", "");
			statement = connect.prepareStatement
					("insert into `pizzas` set ID=?, NAME=?, CATEGORY=?, PRICE=?");
			
			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getLibelle());
			statement.setString(3, pizza.getCategorie());
			statement.setDouble(4, pizza.getPrix());
			statement.execute();
			
			statement.close();
			connect.close();
			
		}catch(SQLException e){
			e.getMessage();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		try{
			connect = DriverManager.getConnection(jdbcUrl, "root", "");
			statement = connect.prepareStatement
					("update `pizzas` set ID=?, NAME=?, CATEGORY=?, PRICE=? where ID=?");
			
			statement.setString(5, codePizza);
			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getLibelle());
			statement.setString(3, pizza.getCategorie());
			statement.setDouble(4, pizza.getPrix());
			
			statement.executeUpdate();
			
			statement.close();
			connect.close();
			
		}catch(SQLException e){
			e.getMessage();
		}
		
	}

	@Override
	public void deletePizza(String codePizza) {
		try{
			connect = DriverManager.getConnection(jdbcUrl, "root", "");
			statement = connect.prepareStatement
					("delete from`pizzas` where `ID`=?");
			
			statement.setString(1, codePizza);
			statement.execute();
			
			statement.close();
			connect.close();
			
		}catch(SQLException e){
			e.getMessage();
		}
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaFindIt = null;
		try{
			connect = DriverManager.getConnection(jdbcUrl, "root", "");
			statement = connect.prepareStatement
					("select * from`pizzas` where `ID`=?");
			
			statement.setString(1, codePizza);
			
			ResultSet result = statement.executeQuery();
			pizzaFindIt = new Pizza(result.getString("ID"), result.getString("NAME"), 
					result.getString("CATEGORY"), result.getDouble("PRICE"));
			
			result.close();
			statement.close();
			connect.close();
			
		}catch(SQLException e){
			e.getMessage();
		}
		return pizzaFindIt;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		
		boolean answer = false;
		
		try{
			connect = DriverManager.getConnection(jdbcUrl, "root", "");
			statement = connect.prepareStatement("select `ID` from`pizzas`");
			
			ResultSet result = statement.executeQuery();
			
			
			while(result.next()){
				String id = result.getString("ID");
				if(id.equals(codePizza)) answer = true;
			}
			
			result.close();
			statement.close();
			connect.close();
			
		}catch(SQLException e){
			e.getMessage();
		}
		
		return answer;
	}

}
