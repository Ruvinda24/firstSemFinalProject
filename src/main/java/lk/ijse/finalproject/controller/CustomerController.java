package lk.ijse.finalproject.controller;

import lk.ijse.finalproject.dto.CustomerDto;
import lk.ijse.finalproject.model.CustomerModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {
    private CustomerModel customerModel = new CustomerModel();

    public String saveCustomer(CustomerDto customerDto) throws ClassNotFoundException, SQLException {
        String resp = customerModel.saveCustomers(customerDto);
        return resp;

    }
    public String updateCustomer(CustomerDto customerDto) throws ClassNotFoundException, SQLException {
        String resp = customerModel.updateCustomers(customerDto);
        return resp;

    }    public String deleteCustomer(CustomerDto customerDto) throws ClassNotFoundException, SQLException {
        String resp = customerModel.deleteCustomers(customerDto.getCustomerId());
        return resp;

    }

    public CustomerDto searchCustomer(String customerCode) throws ClassNotFoundException, SQLException {
        CustomerDto resp = customerModel.searchCustomers(customerCode);
        return resp;
    }

    public ArrayList<CustomerDto> getAll() throws ClassNotFoundException, SQLException{
        ArrayList<CustomerDto> resp = customerModel.getAllCustomers();
        return resp;
    }
}

