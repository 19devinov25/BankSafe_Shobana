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
    import com.edutech.progressive.entity.Customers;
    import com.edutech.progressive.exception.CustomerAlreadyExistsException;
    import com.edutech.progressive.service.impl.CustomerServiceImplArraylist;
    import com.edutech.progressive.service.impl.CustomerServiceImplJpa;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.sql.SQLException;
    import java.util.List;

    @RestController
    @RequestMapping("/customers")
    public class CustomerController {
        @Autowired
        private CustomerServiceImplJpa customerServiceJpa;
        @Autowired
        private CustomerServiceImplArraylist customerServiceArraylist;

        
        // @Autowired
        // public CustomerController(CustomerServiceImplJpa customerServiceJpa,
        //         CustomerServiceImplArraylist customerServiceArraylist) {
        //     this.customerServiceJpa = customerServiceJpa;
        //     this.customerServiceArraylist = customerServiceArraylist;
        // }

        @GetMapping
        public ResponseEntity<List<Customers>> getAllCustomers() {
            try {
                List<Customers> customers = customerServiceJpa.getAllCustomers();
                return new ResponseEntity<>(customers, HttpStatus.OK);
            } catch (SQLException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            // return null;
        }

        @GetMapping("/{customerId}")
        public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId) {
            try {
                Customers customers = customerServiceJpa.getCustomerById(customerId);
                if (customers != null) {
                    return new ResponseEntity<>(customers, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (SQLException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            // return null;
        }

        @PostMapping
        public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) {
            try {
                int customerId = customerServiceJpa.addCustomer(customers);
                return new ResponseEntity<>(customerId, HttpStatus.CREATED);
            } catch (SQLException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            //  catch (SQLException e) {
            //     return new ResponseEntity<>("Unable to process your request at the moment", HttpStatus.INTERNAL_SERVER_ERROR);
            // }
            //return null;
        }

        @PutMapping("/{customerId}")
        public ResponseEntity<?> updateCustomer(@PathVariable int customerId, @RequestBody Customers customers) {
            try {
                customers.setCustomerId(customerId);
                customerServiceJpa.updateCustomer(customers);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (SQLException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            } 
            // catch (SQLException e) {
            //     return new ResponseEntity<>("Unable to process your request at the moment", HttpStatus.INTERNAL_SERVER_ERROR);
            // }
            
        }

        @DeleteMapping("/{customerId}")
        public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
            try {
                customerServiceJpa.deleteCustomer(customerId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (SQLException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        }

        @GetMapping("/fromArrayList")
        public ResponseEntity<List<Customers>> getAllCustomersFromArrayList() throws SQLException {
            List<Customers> customers = customerServiceArraylist.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }

        @PostMapping("/toArrayList")
        public ResponseEntity<Integer> addCustomersToArrayList(@RequestBody Customers customers) throws SQLException {
            int customersList = customerServiceArraylist.addCustomer(customers);
            return new ResponseEntity<>(customersList, HttpStatus.CREATED);
        }

        @GetMapping("/fromArrayList/all")
        public ResponseEntity<List<Customers>> getAllCustomersSortedByNameFromArrayList() throws SQLException {
            List<Customers> customersList = customerServiceArraylist.getAllCustomersSortedByName();
            return new ResponseEntity<>(customersList, HttpStatus.OK);
        }
    }