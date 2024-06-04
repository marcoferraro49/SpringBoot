package co.develhope.middleware02.interceptors;

import co.develhope.middleware02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1,"January","Gennaio","Januar"),
            new Month(2,"February","Febbraio","Februar"),
            new Month(3,"March","Marzo","Marsch"),
            new Month(4,"April","Aprile","April"),
            new Month(5,"May","Maggio","Mai"),
            new Month(6,"June","Giugno","Juni")
    ));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthStr = request.getHeader("monthNumber");

        if (monthStr == null || monthStr.isEmpty()) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "monthNumber header is required");
            return false;
        }

        int monthNumber = Integer.parseInt(monthStr);

        Month month = months.stream()
                .filter(m -> m.getMonthNumber() == monthNumber)
                .findFirst()
                .orElseGet(() -> {
                    Month emptyMonth = new Month();
                    emptyMonth.setMonthNumber(monthNumber);
                    emptyMonth.setEnglishName("nope");
                    emptyMonth.setItalianName("nope");
                    emptyMonth.setGermanName("nope");
                    return emptyMonth;
                });

        request.setAttribute("month", month);
        response.setStatus(HttpStatus.OK.value());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
