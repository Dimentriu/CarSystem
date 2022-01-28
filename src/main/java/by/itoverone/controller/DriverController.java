package main.java.by.itoverone.controller;

import main.java.by.itoverone.service.ClientService;

public class DriverController {
    @Controller
    @RequestMapping("/driver")
    public class AdminController {
        private final DriverService driverServiceriverService;
        private final main.java.by.itoverone.controller.DriverService DriverService;
        private DriverService driverService;
        private DriverService clientService;

        @Autowired
        public AdminController(
                DriverService adminService, DriverService clientService) {
            this.driverServiceriverService = driverService;
            this.DriverService = clientService;

        }

        @GetMapping
        public String home() {
            return "driverHome";
        }

        @GetMapping("/direction")
        public String toSelectDirection(Direction direction) {
            return "adminSelectDirection";
        }

    }
}
