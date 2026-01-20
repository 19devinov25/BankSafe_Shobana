// package com.edutech.progressive.controller;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.edutech.progressive.entity.Customers;
// import com.edutech.progressive.entity.Transactions;
// import com.edutech.progressive.service.CustomerService;

// import java.util.List;
// @RestController
// @RequestMapping("/customers")
// public class CustomerController {
//     @Autowired
//      CustomerService customerService;
    
//      @GetMapping
//     public ResponseEntity<List<Customers>> getAllCustomers() {
//         return null;
//     }
// //    @GetMapping("/{customerID}")
// //     public ResponseEntity<Customers> getCustomerById(int customerId) {
// //         return null;
// //     }

//     @GetMapping("/{customerID}")
//     public Customers getCustomerById(int customerId){
//         return null;
//     }
//     @GetMapping("/fromArrayList")
//     public List<Customers> getAllCustomersFromArrayList(){
//       return null;
//     }

//     @GetMapping("/fromArrayList/all")
//     public List<Customers> getAllCustomersSortedByNameFromArrayList(){
//         return null;
//     }
//     @PostMapping
//     public int addCustomer(Customers customers){
//       return -1;
//     }
//     @PostMapping("/toArrayList")
//     public int addCustomersToArrayList(Customers customers){
//         return -1;
//     }
//     @PutMapping("{customerID}")
//     public void updateCustomer(int customerId, Customers customers){
      
//     }
//     @DeleteMapping("{customerID}")
//     public void deleteCustomer(int customerID){

//     }



//     // public ResponseEntity<Integer> addCustomer(Customers customers) {
//     //     return null;
//     // }

//     // public ResponseEntity<Void> updateCustomer(int customerId, Customers customers) {
//     //     return null;
//     // }
//     // public ResponseEntity<Void> deleteCustomer(int customerId) {
//     //     return null;
//     // }

//     // public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int customerId) {
//     //     return null;
//     // }
// }



package com.edutech.progressive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.service.CustomerService;
import com.edutech.progressive.service.impl.CustomerServiceImplArraylist;
import com.edutech.progressive.service.impl.CustomerServiceImplJpa;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
   @Autowired
private CustomerServiceImplJpa customerServiceImplJpa;
@Autowired
private CustomerServiceImplArraylist customerServiceImplArraylist;
    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
      return null;
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId){
       return null;
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Customers>> getAllCustomersFromArrayList(){
    return null;
    }

    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Customers>> getAllCustomersSortedByNameFromArrayList(){
   return null;
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customers customers){
      return null;
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<?> addCustomersToArrayList(@RequestBody Customers customers){
     return null;
    }

    @PutMapping("/{customerID}")
    public ResponseEntity<?> updateCustomer(@PathVariable("customerID") int customerId, @RequestBody Customers customers){
     return null;
    }

    @DeleteMapping("/{customerID}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerID") int customerID){
        return null;
    }
}
