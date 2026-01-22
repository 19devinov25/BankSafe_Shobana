// // package com.edutech.progressive.service.impl;
 
// // import java.sql.SQLException;
// // import java.util.ArrayList;
// // import java.util.Collections;
// // import java.util.List;
 
// // import org.springframework.stereotype.Service;
 
// // import com.edutech.progressive.entity.Customers;
// // @Service
// // public class CustomerServiceImplArraylist {
// //     private static List<Customers> customersList = new ArrayList<>();
 
// //     public List<Customers> getAllCustomers() throws SQLException {
// //         return customersList;
// //     }
 
// //     public int addCustomer(Customers customers) throws SQLException {
// //         customersList.add(customers);
// //         return customersList.size();
// //     }
 
// //     public List<Customers> getAllCustomersSortedByName() throws SQLException {
// //         List <Customers> tempList=new ArrayList<>(customersList);
// //         Collections.sort(tempList);
// //         return tempList;
// //     }
// //     public Customers getCustomerById(int customerId) throws SQLException{
// //         for (Customers customers : customersList) {
// //             if(customers.getCustomerId()==customerId){
// //                 return customers;
// //             }
// //         }
// //         return null;
// //     }
 
// //     public void emptyArrayList() {
// //          customersList=new ArrayList<>();
// //     }
// // }

// package com.edutech.progressive.service.impl;

// import com.edutech.progressive.entity.Customers;

// import java.sql.SQLException;

// import java.util.ArrayList;

// import java.util.Collections;

// import java.util.List;

// import com.edutech.progressive.entity.Customers;

// import java.sql.SQLException;

// import java.util.ArrayList;

// import java.util.Collections;

// import java.util.List;

// public class CustomerServiceImplArraylist {

//     // In-memory list used to store customer objects.

//     private static List<Customers> customersList = new ArrayList<>();


//     public List<Customers> getAllCustomers() throws SQLException {

//         return new ArrayList<>(customersList);

//     }


//     public int addCustomer(Customers customers) throws SQLException {

//         customersList.add(customers);

//         return customersList.size();

//     }


//     public List<Customers> getAllCustomersSortedByName() throws SQLException {

//         List<Customers> copy = new ArrayList<>(customersList);

//         Collections.sort(copy);

//         return copy;

//     }


//     public Customers getCustomerById(int customerId) throws SQLException {

//         for (Customers c : customersList) {

//             if (c.getCustomerId() == customerId) return c;

//         }

//         return null;

//     }


//     public void emptyArrayList() {

//         customersList = new ArrayList<>();

//     }

// }
 
package com.edutech.progressive.service.impl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.service.CustomerService;
 
@Service
public class CustomerServiceImplArraylist implements CustomerService{
    private static List<Customers> customerList = new ArrayList<>();
 
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customerList;
    }
 
    @Override
    public int addCustomer(Customers customers) throws SQLException {
        customerList.add(customers);
        return customerList.size();
    }
 
    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        Collections.sort(customerList);
        return customerList;
    }
 
    public void emptyArrayList(){
        customerList.clear();
    }
}