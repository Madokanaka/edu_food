package org.attractor.edu_food.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.attractor.edu_food.exceptions.BadRequestException;
import org.attractor.edu_food.exceptions.DatabaseOperationException;
import org.attractor.edu_food.exceptions.NoAccessException;
import org.attractor.edu_food.exceptions.RecordAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.NoSuchElementException;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFoundException(Model model, HttpServletRequest request, NoSuchElementException e) {
        model.addAttribute("status", HttpStatus.NOT_FOUND.value());
        model.addAttribute("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
        model.addAttribute("details", request);
        model.addAttribute("message", e.getMessage());
        return "errors/error";
    }

    @ExceptionHandler(DatabaseOperationException.class)
    public String handleDatabaseOperationException(Model model, HttpServletRequest request, DatabaseOperationException e) {
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("reason", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        model.addAttribute("details", request);
        model.addAttribute("message", e.getMessage());
        return "errors/error";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validationHandler(Model model, HttpServletRequest request, MethodArgumentNotValidException e) {
        model.addAttribute("status", HttpStatus.BAD_REQUEST.value());
        model.addAttribute("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        model.addAttribute("details", request);
        model.addAttribute("message", e.getMessage());
        return "errors/error";
    }

    @ExceptionHandler(RecordAlreadyExistsException.class)
    public String handleRecordAlreadyExistsException(Model model, HttpServletRequest request, RecordAlreadyExistsException e) {
        model.addAttribute("status", HttpStatus.CONFLICT.value());
        model.addAttribute("reason", HttpStatus.CONFLICT.getReasonPhrase());
        model.addAttribute("details", request);
        model.addAttribute("message", e.getMessage());
        return "errors/error";    }

    @ExceptionHandler(BadRequestException.class)
    public String handleBadRequestException(Model model, HttpServletRequest request, BadRequestException e) {
        model.addAttribute("status", HttpStatus.BAD_REQUEST.value());
        model.addAttribute("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        model.addAttribute("details", request);
        model.addAttribute("message", e.getMessage());
        return "errors/error";    }

    @ExceptionHandler(NoAccessException.class)
    public String handleNoAccessException(Model model, HttpServletRequest request, NoAccessException e) {
        model.addAttribute("status", HttpStatus.FORBIDDEN.value());
        model.addAttribute("reason", HttpStatus.FORBIDDEN.getReasonPhrase());
        model.addAttribute("details", request);
        model.addAttribute("message", e.getMessage());
        return "errors/error";    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Файл слишком большой. Максимальный размер файла: 10MB.");
        return "redirect:/profile";
    }

    @ExceptionHandler(MultipartException.class)
    public String handleMultipartException(MultipartException ex, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("error", "Ошибка при загрузке файла: файл слишком большой или повреждён.");
        return "redirect:/profile";
    }
}
