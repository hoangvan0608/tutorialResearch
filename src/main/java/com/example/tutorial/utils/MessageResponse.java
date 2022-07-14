package com.example.tutorial.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class MessageResponse {
    public static void alert(RedirectAttributes model, String message, String alert) {
        model.addFlashAttribute("message", message);
        model.addFlashAttribute("alert", alert);
    }

    public static void successAlert(RedirectAttributes model, String message) {
        model.addFlashAttribute("message", message);
        model.addFlashAttribute("alert", "success");
    }

    public static void warningAlert(RedirectAttributes model, String message) {
        model.addFlashAttribute("message", message);
        model.addFlashAttribute("alert", "warning");
    }
    public static void dangerAlert(RedirectAttributes model, String message) {
        model.addFlashAttribute("message", message);
        model.addFlashAttribute("alert", "danger");
    }
}
