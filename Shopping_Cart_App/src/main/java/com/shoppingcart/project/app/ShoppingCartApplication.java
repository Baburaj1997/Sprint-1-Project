package com.shoppingcart.project.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.shoppingcart.project.app.controller.CustomerController;
import com.shoppingcart.project.app.controller.EmployeeController;
import com.shoppingcart.project.app.controller.OfficeController;
import com.shoppingcart.project.app.controller.OrderController;
import com.shoppingcart.project.app.controller.OrderDetailController;
import com.shoppingcart.project.app.controller.PaymentController;
import com.shoppingcart.project.app.controller.ProductController;
import com.shoppingcart.project.app.controller.ProductLineController;
import com.shoppingcart.project.app.exception.CustomerNotFoundException;
import com.shoppingcart.project.app.exception.EmployeeNotFoundException;
import com.shoppingcart.project.app.exception.OfficeNotFoundException;
import com.shoppingcart.project.app.exception.OrderDetailNotFoundException;
import com.shoppingcart.project.app.exception.OrderNotFoundException;
import com.shoppingcart.project.app.exception.PaymentNotFoundException;
import com.shoppingcart.project.app.exception.ProductLineNotFoundException;
import com.shoppingcart.project.app.exception.ProductNotFoundException;
import com.shoppingcart.project.app.model.Customer;
import com.shoppingcart.project.app.model.Employee;
import com.shoppingcart.project.app.model.Office;
import com.shoppingcart.project.app.model.Order;
import com.shoppingcart.project.app.model.OrderDetail;
import com.shoppingcart.project.app.model.Payment;
import com.shoppingcart.project.app.model.Product;
import com.shoppingcart.project.app.model.ProductLine;

@SpringBootApplication
public class ShoppingCartApplication implements CommandLineRunner  {

	@Autowired
	private ProductController productController;
	
	@Autowired
	private ProductLineController productLineController;
	
	@Autowired
	private OfficeController officeController;
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private OrderController orderController;
	
	@Autowired
	private OrderDetailController orderDetailController;
	
	@Autowired
	private PaymentController paymentController;
	
	@Autowired
	private CustomerController customerController;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-----------------------------------------------------------");
		System.out.println("                       Products Records                    ");
		System.out.println("-----------------------------------------------------------");
		addProducts(createProducts());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                      productLines Records                 ");
		System.out.println("-----------------------------------------------------------");
		addProductLine(createProductLines());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                         Orders Records                    ");
		System.out.println("-----------------------------------------------------------");
		addOrder(createOrder());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                      OrderDetails Records                 ");
		System.out.println("-----------------------------------------------------------");
		addOrderDetail(createOrderDetail());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                        Customers Records                  ");
		System.out.println("-----------------------------------------------------------");
		addCustomer(createCustomer());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                        Payments Records                   ");
		System.out.println("-----------------------------------------------------------");
		addPayment(createPayment());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                       Employees Records                   ");
		System.out.println("-----------------------------------------------------------");
		addEmployee(createEmployee());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                        Offices Records                    ");
		System.out.println("-----------------------------------------------------------");
		addOffice(createOffice());
		
	}

	private void addProducts(List<Product> products) throws ProductNotFoundException {
		for (Product product : products) {
			productController.createProduct(product);
			
		}
	}
	
	
	private void addProductLine(List<ProductLine> productLines) throws ProductLineNotFoundException {
		for (ProductLine productLine : productLines) {
			productLineController.createProductLine(productLine);
			}
		}
	
	private void addCustomer(List<Customer> customers) throws CustomerNotFoundException {
		for (Customer customer :customers) {
			customerController.createCustomer(customer);
			}
		}
	
	private void addOrder(List<Order> orders) throws OrderNotFoundException {
		for (Order order :orders) {
			orderController.createOrder( order);
		}
	}
	
	private void addOrderDetail(List<OrderDetail> orderDetails) throws OrderDetailNotFoundException {
		for (OrderDetail orderDetail :orderDetails) {
			orderDetailController.createOrderDetails( orderDetail);
		}
	}
	
	private void addPayment(List<Payment> payments) throws PaymentNotFoundException {
		for (Payment payment :payments) {
			paymentController.createPayment(payment);
		}
	}
	
	private void addEmployee(List<Employee> employees) throws EmployeeNotFoundException {
		for (Employee employee :employees) {
			employeeController.createEmployee(employee);
		}
	}
	

	private void addOffice(List<Office> offices) throws OfficeNotFoundException {
		for (Office office :offices) {
			officeController.createOffice(office);
		}
	}
	
	private List<Product> createProducts() {
		
// ----------------------- create object------------------------------
				
				Product product1 = new  Product(1L,"Samsung A50s ","flexiphone ","Samsung Electronics pvt","build for quality, "
						+ "korean Company.",150,135.10,293.34,null,null);		
						
				
						
//-----------------------------add in list------------------------------
				List<Product> products= new ArrayList<>();
				products.add(product1);
			//	products.add(product2);
			//	products.add(product3);
			//	products.add(product4);
		 
		 return products;
		

	}
	
		private List<ProductLine> createProductLines() {
		
// ---------------------- Create Object ---------------------------
			
				ProductLine	productLine1 = new ProductLine(1L,"mobile and elctronics "
						+ "Electronics","<ol>"
					    + "<li>samsung Electronics .<li>"
					    + "<li>Its products which is branded and trusted<li>"
					    + "<ol>","D:\\Image of Project ANUD.jpg",null);
				
				 
				
				 
 //------------------- add in list -----------------------------------
				
				 List<ProductLine> productLinelist = new ArrayList<>();
					
				 productLinelist.add(productLine1);
			//	 productLinelist.add(productLine2);
			//	 productLinelist.add(productLine3);
				 
		return  productLinelist;
		
	}
		
			
		public List<Order> createOrder(){
			
		
			//Create Object
			Order order1 = new Order(new Date(2022, 11, 10),new Date(2022, 11, 22),new Date(2022, 11, 15),true,"Out for Delivery",null,null); 
			
			List<Order> orderlist = new ArrayList<>();
			
// -------------------  add in list -----------------------------------
			
			orderlist .add(order1);
		//	orderlist .add(order2);
		//	orderlist .add(order3);
		//	orderlist .add(order4);

			return orderlist;
		
		}
		
		public List<OrderDetail> createOrderDetail(){
			
			
			//Create object
			OrderDetail ordetail1 = new OrderDetail(2,550.70,1,null); 
			
			List<OrderDetail> orderDetaillist = new ArrayList<>();

//---------------------- add in list ---------------------------------
			
		    orderDetaillist.add(ordetail1);
		//	orderDetaillist.add(ordetail2);
		//	orderDetaillist.add(ordetail3);
		
			
			return  orderDetaillist;

		}
		
		public List<Customer> createCustomer(){
			
			//Customer Object
			
			Customer customer1 = new Customer(1L,"Viraj Kumar","Kumar","Viraj", "6202054997","Hinoo, Ranchi", "Hinoo ,Ranchi",
		 			 "Ranchi","Jharkhand", 834002,"India", 15L, 50L, null, null,null);	 
			
//---------------------- add in list -----------------------------
	
			List<Customer> customerList = new ArrayList<>();
			 customerList.add(customer1);
		//	 customerList.add(customer2);
		//	 customerList.add(customer3);
		
			return  customerList;
			}
		
		
		
		public List<Payment>  createPayment(){
	
//------------------Create object -------------------------------
			
			Payment pay1 = new Payment(1L,new Date(2022, 11, 10) ,550.70,null); 
			
			
			List<Payment> paymentlist = new ArrayList<>();
			
//--------------------add in list ----------------------------------
			
			paymentlist.add(pay1);
		//	paymentlist.add(pay2);
		//	paymentlist.add(pay3);
		
			
			return paymentlist;
		
			}
		
		
		public List<Employee> createEmployee(){
			//Employee Object
			Employee employee1 = new Employee(1L,"RajMohan", "Pratik", "Full-time", "pratik@gmail.com", 
					"infotech-0020", "S.rao", "Full-stack dev", null, null,null);
		
			
			List<Employee> employeelist = new ArrayList<>();
			
//----------------------add in list------------------------------------
			
			employeelist.add(employee1);
		//	employeelist.add(employee2);
		//	employeelist.add(employee3);
		
		
			return employeelist;
		
		} 
		
		public List<Office> createOffice(){
			
//-----------------------Create object ---------------------------------------
			
			Office office1 = new Office(1L,"Ranchi","6262005135","MG Road","krishna market","Ratu","India",800001,"Patna",null);
		
			List<Office> officelist = new ArrayList<>();
			
			//add in list	
			officelist.add(office1);
		//	officelist.add(office2);
		//	officelist.add(office3);
		
			return officelist;
		
		}
//-------------------------the end----------------------------------------------		
}