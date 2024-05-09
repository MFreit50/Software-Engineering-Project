import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import dataengine.DataEngineService.DataEngineResponse;

public class UserInterface{
    private JFrame frame;
    private JTextField inputField;
    private JTextField outputFileField;
    private JCheckBox useNumbersCheckbox;
    private JButton fileChooserButton;
    private JButton submitButton;
    private JLabel inputLabel;

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            UserInterface ui = new UserInterface();
            ui.createAndShowGUI();
        });
    }

    public void createAndShowGUI(){
        //Create and configure the main frame
        frame = new JFrame("User Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Checkbox to indicate whether to use numbers or file path
        useNumbersCheckbox = new JCheckBox("Use numbers");
        useNumbersCheckbox.addActionListener(new CheckboxListener());
        panel.add(useNumbersCheckbox); //Moved to the top

        //Input field for file path or numbers
        inputField = new JTextField(20);
        inputLabel = new JLabel("Type in file directory:");
        panel.add(inputLabel);
        panel.add(inputField);

        //Button to open file chooser dialog
        fileChooserButton = new JButton("Choose File");
        fileChooserButton.addActionListener(new FileChooserButtonListener());
        panel.add(fileChooserButton);

        //Output file path field
        outputFileField = new JTextField(20);
        panel.add(new JLabel("Insert output path:"));
        panel.add(outputFileField);

        //Button to submit the input
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        panel.add(submitButton);

        //Add the panel to the frame
        frame.getContentPane().add(panel);

        //Pack the components and display the frame
        frame.pack();
        frame.setVisible(true);
    }

    //Listener for the "Choose File" button
    private class FileChooserButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                inputField.setText(selectedFile.getAbsolutePath());
            }
        }
    }

    //Listener for the "Use numbers" checkbox
    private class CheckboxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (useNumbersCheckbox.isSelected()){
                inputField.setText("");
                inputField.setEnabled(true);
                fileChooserButton.setEnabled(false); //Disable file chooser button
                inputLabel.setText("Write numbers:"); //Change label text
            }else{
                inputField.setText("");
                inputField.setEnabled(true); //Enable input field even when not using numbers
                fileChooserButton.setEnabled(true); //Enable file chooser button
                inputLabel.setText("Type in file directory:"); //Change label text back
            }
        }
    }

    //Listener for the "Submit" button
    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                String input = inputField.getText();
                String outputPath = outputFileField.getText();

                // Check if any required field is empty
                if (input.isEmpty() || outputPath.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean useNumbers = useNumbersCheckbox.isSelected();

                if (useNumbers){
                    List<String> numberList = List.of(input.split("\\s*,\\s*"));
                    StringBuilder fileContent = new StringBuilder();
                    for (String number : numberList){
                        fileContent.append(number).append("\n");
                    }

                    Path filePath = Paths.get(outputPath);
                    Files.write(filePath, fileContent.toString().getBytes());

                    input = outputPath;
                }

                FileInputConfig fileInputPath = new FileInputConfig(input);
                FileOutputConfig fileOutputPath = new FileOutputConfig(outputPath);
                UserRequest userRequest = new UserRequest(fileInputPath, fileOutputPath);
                Coordinator coordinator = new Coordinator();
                DataEngineResponse dataResult = coordinator.initiate(userRequest);

                JOptionPane.showMessageDialog(frame, dataResult.getEngineStatus() + dataResult.getErrorMessage());
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}