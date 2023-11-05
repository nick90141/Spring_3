package Task_2_3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/dataServlet")
public class DataServlet extends HttpServlet {
    private DataController controller = new DataController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String item = request.getParameter("data");

        if (item != null && !item.isEmpty()) {
            saveDataToFile(item);
            controller.addData(item);
            response.getWriter().write("Дані успішно збережено.");

            int totalCount = controller.getTotalCount();
            response.getWriter().write("<br>Загальна кількість записів: " + totalCount);
        } else {
            response.getWriter().write("Помилка: введіть дані.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalCount = controller.getTotalCount();
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write("Загальна кількість записів: " + totalCount);

        if (request.getParameter("showAll") != null) {
            List<String> allData = getAllDataFromFile();
            response.getWriter().write("<br>Усі дані з файлу: <br>");
            for (String data : allData) {
                response.getWriter().write(data + "<br>");
            }
        }
    }

    private List<String> getAllDataFromFile() {
        List<String> allData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                allData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allData;
    }


    private void saveDataToFile(String data) {
        try (FileWriter fileWriter = new FileWriter("data.txt", true)) {
            Date currentDate = new Date();
            System.out.println("Путь к файлу data.txt: " + new File("data.txt").getAbsolutePath());
            fileWriter.write(currentDate.toString() + ": " + data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
