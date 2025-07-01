import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addButton, deleteButton;

    public ToDoApp() {
        setTitle("To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskInput = new JTextField();
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Selected");

        // Panel for input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        inputPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add components to frame
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Add button actions
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}
