package com.sparta.pbl_week2.controller;

//Not Using!!
//public class HomeController {
//    @GetMapping("/")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        if (userDetails != null) {
//            model.addAttribute("username", userDetails.getUsername());
//
//            if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
//                model.addAttribute("admin_role", true);
//            }
//        }
//
//        return "index";
//    }
//}
//@Controller
//public class HomeController {
//    @GetMapping("/")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return "index";
//    }
//}