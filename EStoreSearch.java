package estoresearch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class EStoreSearch extends JFrame{
    private static ArrayList<Product> product = new ArrayList<>(); 
    private static HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

    private static final Color VERY_LIGHT_BLUE = new Color(51, 204, 255);
    private static final Color VERY_LIGHT_GREEN = new Color(102, 255, 102);
    private static JPanel welcomePanel;
    private static JPanel addPanel;
    private static JPanel addPanel2;
    private static JPanel addPanel3;
    private static JPanel searchPanel;
    private static JPanel searchPanel2;
    private static JPanel searchPanel3;

    private static JLabel authorLabel;
    private static JLabel pubLabel;
    private static JLabel makerLabel;

    private static JTextField idText;
    private static JTextField descText;
    private static JTextField priceText;
    private static JTextField yearText;
    private static JTextField authorText;
    private static JTextField pubText;
    private static JTextField makerText;

    private static JTextField idSearchText;
    private static JTextField descSearchText;
    private static JTextField startYearText;
    private static JTextField endYearText;

    private static JButton resetButton;
    private static JButton addButton;

    private static JButton SearchResetButton;
    private static JButton searchButton;

    private static JTextArea AddBox;
    private static JTextArea SearchBox;

    private static String[] tempArgs;

    private static int WIDTH = 600;
    private static int HEIGHT = 600;

    /**
    * Action Listener for when the user select 'Add' from the Menu Bar
    */
    private class AddListenter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            /**
            * Set visibilities when if user switch between different commands
            */
            if(welcomePanel != null){
                if(welcomePanel.isVisible() == true){
                    welcomePanel.setVisible(false);
                }
            }
            if(searchPanel != null){
                if(searchPanel.isVisible() == true){
                    searchPanel.setVisible(false);
                    searchPanel2.setVisible(false);
                    searchPanel3.setVisible(false);
                }
            }
            if(addPanel != null){
                if(addPanel.isVisible() == false){
                    AddBox.setText("");
                    addPanel.setVisible(true);
                    addPanel2.setVisible(true);
                    addPanel3.setVisible(true);
                }
            }else{
                //panel on the left
                addPanel = new JPanel();
                addPanel.setBackground(VERY_LIGHT_BLUE);
                addPanel.setLayout(null);
                addPanel.setBounds(0, 0, 400, 360);

                //panel rigth
                addPanel2 = new JPanel();
                addPanel2.setBackground(VERY_LIGHT_BLUE);
                addPanel2.setLayout(null);
                addPanel2.setBounds(400, 0, 200, 360);

                //bottom panel
                addPanel3 = new JPanel();
                addPanel3.setBackground(VERY_LIGHT_BLUE);
                addPanel3.setLayout(null);
                addPanel3.setBounds(0, 340, 600, 240);

                addPanel.setVisible(true);
                addPanel2.setVisible(true);
                addPanel3.setVisible(true);
                /**
                * Everything below are to arrange spots for Labels, Buttons, Text Field and Combo Box
                */

                JLabel addLabel = new JLabel("Adding A product");
                addLabel.setBounds(10, 10, 120, 25);
                addPanel.add(addLabel);
            
                JLabel typeLabel = new JLabel("Type:");
                typeLabel.setBounds(25, 50, 50, 25);
                addPanel.add(typeLabel);

                authorLabel = new JLabel("Authors:");
                authorLabel.setBounds(24, 250, 150, 25);
                addPanel.add(authorLabel);

                authorText = new JTextField();
                authorText.setBounds(130, 250, 250, 25);
                addPanel.add(authorText);

                pubLabel = new JLabel("Publisher:");
                pubLabel.setBounds(24, 290, 150, 25);
                addPanel.add(pubLabel);

                pubText = new JTextField();
                pubText.setBounds(130, 290, 250, 25);
                addPanel.add(pubText);

                makerLabel = new JLabel("Maker:");
                makerLabel.setBounds(24, 240, 150, 25);
                addPanel.add(makerLabel);
                makerLabel.setVisible(false);

                makerText = new JTextField();
                makerText.setBounds(130, 240, 250, 25);
                addPanel.add(makerText);
                makerText.setVisible(false);
                
                String type[] = {"Book", "Electronic"};
                JComboBox typeBox = new JComboBox(type);
                typeBox.setBounds(130, 50, 150, 25);
                typeBox.addActionListener(new TypeBoxListener());
                addPanel.add(typeBox);

                JLabel idLabel = new JLabel("ProductID:");
                idLabel.setBounds(24, 90, 150, 25);
                addPanel.add(idLabel);

                idText = new JTextField();
                idText.setBounds(130, 90, 70, 25);
                addPanel.add(idText);

                JLabel descLabel = new JLabel("Description:");
                descLabel.setBounds(24, 130, 150, 25);
                addPanel.add(descLabel);

                descText = new JTextField();
                descText.setBounds(130, 130, 250, 25);
                addPanel.add(descText);

                JLabel priceLabel = new JLabel("Price:");
                priceLabel.setBounds(24, 170, 150, 25);
                addPanel.add(priceLabel);

                priceText = new JTextField();
                priceText.setBounds(130, 170, 70, 25);
                addPanel.add(priceText);

                JLabel yearLabel = new JLabel("Year:");
                yearLabel.setBounds(24, 210, 150, 25);
                addPanel.add(yearLabel);

                yearText = new JTextField();
                yearText.setBounds(130, 210, 70, 25);
                addPanel.add(yearText);

                resetButton = new JButton("Reset");
                resetButton.setBounds(60, 70, 70, 40);
                resetButton.addActionListener(new ResetListenerAdd());
                addPanel2.add(resetButton);

                addButton = new JButton("Add");
                addButton.setBounds(60, 250, 70, 40);
                addButton.addActionListener(new AddProductListener());
                addPanel2.add(addButton);

                JLabel messLabel = new JLabel("Messages");
                messLabel.setBounds(10, 30, 100, 25);
                addPanel3.add(messLabel);

                AddBox = new JTextArea();
                AddBox.setLineWrap(true);
                AddBox.setWrapStyleWord(true);
                AddBox.setOpaque(false);
                AddBox.setEditable(false);
                AddBox.setBorder(BorderFactory.createBevelBorder(1));
                AddBox.setBackground(Color.GRAY); 
            
                JScrollPane messScrollPane = new JScrollPane(AddBox);
                messScrollPane.setBounds(25, 60, 550, 140);
                messScrollPane.setBackground(Color.WHITE);
                messScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                messScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                addPanel3.add(messScrollPane);
                //add these panels to the frame
                add(addPanel);
                add(addPanel2);
                add(addPanel3);
            }
        }
        /**
        * An Action Listener when user click the combo box to switch types
        */
        private class TypeBoxListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox temp = (JComboBox)e.getSource();
                String type = (String)temp.getSelectedItem();

                idText.setText("");
                descText.setText("");
                priceText.setText("");
                yearText.setText("");
                authorText.setText("");
                pubText.setText("");
                makerText.setText("");
                
                if(type.equals("Electronic")){
                    authorLabel.setVisible(false);
                    authorText.setVisible(false);
                    pubLabel.setVisible(false);
                    pubText.setVisible(false);
                    makerLabel.setVisible(true);
                    makerText.setVisible(true);
                } else if(type.equals("Book")){
                    makerLabel.setVisible(false);
                    makerText.setVisible(false);
                    authorLabel.setVisible(true);
                    authorText.setVisible(true);
                    pubLabel.setVisible(true);
                    pubText.setVisible(true);
                }
            }
        }
        // when user click the reset button
        private class ResetListenerAdd implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                idText.setText("");
                descText.setText("");
                priceText.setText("");
                yearText.setText("");
                authorText.setText("");
                pubText.setText("");
                makerText.setText("");
                AddBox.setText("");
            }  
        }
        //when user click the add button
        private class AddProductListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBox.setText("");// set the text are to empty
                int bCounter = 0;
                int eCounter = 0;
                String id = "";
                String desc = "";
                double price = 0.0;
                int year = 0;
                String author = " ";
                String pub = " ";
                String maker = " ";
                /**
                * Different try-catch blocks for exception handlings and get inputs
                */
                try{
                    id = idText.getText();
                    int tempId = Integer.parseInt(id);
                    if(id.length() != 6) throw new Exception();
                    bCounter++;
                    eCounter++;
                }catch(NumberFormatException a){
                    AddBox.append("'Product ID' is mandatory and please make sure your ID is a number.\n");
                }catch(Exception a){
                    AddBox.append("'Product ID' is mandatory and has to be 6 digits long.\n");
                }
                try{
                    desc = descText.getText();
                    if(desc.isEmpty() == true) throw new Exception();
                    bCounter++;
                    eCounter++;
                }catch(Exception a){
                    AddBox.append("Product 'Description' is mandatory.\n");
                }
                try{
                    String tempPrice = priceText.getText();
                    if(tempPrice.isEmpty() == true){
                        price = 0.0;
                    } else {
                        price = Double.parseDouble(tempPrice);
                    }
                    bCounter++;
                    eCounter++;
                }catch(NumberFormatException a){
                    AddBox.append("Please make sure 'Price' is a number.\n");
                }
                try{
                    String tempYear = yearText.getText();
                    year = Integer.parseInt(tempYear);
                    if(year < 1000 || year > 9999) throw new Exception();
                    bCounter++;
                    eCounter++;
                }catch(NumberFormatException a){
                    AddBox.append("'Year' is mandatory and make sure 'Year' is a number.\n");
                }catch(Exception a){
                    AddBox.append("'Year' is mandatory and and to be between 1000-9999.\n");
                }
                if(authorLabel.isVisible() == true && pubLabel.isVisible() == true && makerLabel.isVisible() == false){    
                    author = authorText.getText();
                    if(author.isEmpty() == true){
                        author = "";
                    }
                    bCounter++;
                    pub = pubText.getText();
                    if(pub.isEmpty() == true){
                        pub = "";
                    }
                    bCounter++;
                }
                if(makerLabel.isVisible() == true && authorLabel.isVisible() == false && pubLabel.isVisible() == false){
                    maker = makerText.getText();
                    if(maker.isEmpty() == true){
                        maker = "";
                    }
                    eCounter++;
                }
                // check if id is already in the system or not before adding it to the ArrayList
                if(idCheck(id) == true){
                    // if user wants to add a bool
                    if(authorLabel.isVisible() == true && pubLabel.isVisible() == true && makerLabel.isVisible() == false){
                        if(bCounter == 6){
                            try{
                                product.add(new Book(id, desc, price, year, author, pub));
                                hashing();
                                AddBox.append("A book added successfully.");
                                idText.setText("");
                                descText.setText("");
                                priceText.setText("");
                                yearText.setText("");
                                authorText.setText("");
                                pubText.setText("");
                                makerText.setText("");
                            }catch(Exception a){
                                AddBox.append("Please make sure your inputs are correct.");
                            }
                        }else{
                            AddBox.append("A book not added. Please check input errors.");
                        }
                    }
                    // if user wants to add an electronic
                    else if(makerLabel.isVisible() == true && authorLabel.isVisible() == false && pubLabel.isVisible() == false){
                        if(eCounter == 5){
                            try{
                                product.add(new Electronic(id, desc, price, year, maker));
                                hashing();
                                AddBox.append("An electronic added successfully.");
                                idText.setText("");
                                descText.setText("");
                                priceText.setText("");
                                yearText.setText("");
                                authorText.setText("");
                                pubText.setText("");
                                makerText.setText("");
                            }catch(Exception a){
                                AddBox.append("Please make sure your inputs are correct.");
                            }
                        }else{
                            AddBox.append("An Electronic not added. Please check input errors.");
                        }
                    }
                }else{
                    AddBox.append("This product already existed in the system.");
                }
            }
        }
    }
    /**
    * If user select Search command from the Menu Bar
    */
    private class SearchListenter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // set visibility when user switch between each commands
            if(addPanel != null){
                if(addPanel.isVisible() == true ){
                    addPanel.setVisible(false);
                    addPanel2.setVisible(false);
                    addPanel3.setVisible(false);
                } 
            }
            if(welcomePanel != null){
                if(welcomePanel.isVisible() == true){
                    welcomePanel.setVisible(false);
                }
            } 
            if(searchPanel != null){
                if(searchPanel.isVisible() == false){
                    SearchBox.setText("");
                    searchPanel.setVisible(true);
                    searchPanel2.setVisible(true);
                    searchPanel3.setVisible(true);
                }
            } else {
                searchPanel = new JPanel();
                searchPanel.setBackground(VERY_LIGHT_GREEN); 
                searchPanel.setLayout(null);
                searchPanel.setBounds(0, 0, 400, 360);

                searchPanel2 = new JPanel();
                searchPanel2.setBackground(VERY_LIGHT_GREEN);
                searchPanel2.setLayout(null);
                searchPanel2.setBounds(400, 0, 200, 360);

                searchPanel3 = new JPanel();
                searchPanel3.setBackground(VERY_LIGHT_GREEN);
                searchPanel3.setLayout(null);
                searchPanel3.setBounds(0, 340, 600, 240);

                JLabel searchLabel = new JLabel("Search products");
                searchLabel.setBounds(10, 10, 120, 25);
                searchPanel.add(searchLabel);

                JLabel idLabel = new JLabel("ProductID:");
                idLabel.setBounds(25, 70, 120, 25);
                searchPanel.add(idLabel);

                idSearchText = new JTextField();
                idSearchText.setBounds(170, 70, 100, 25);
                searchPanel.add(idSearchText);

                JLabel descLabel = new JLabel("Description Keywords:");
                descLabel.setBounds(25, 140, 150, 25);
                searchPanel.add(descLabel);

                descSearchText = new JTextField();
                descSearchText.setBounds(170, 140, 230, 25);
                searchPanel.add(descSearchText);

                JLabel startYear = new JLabel("Start Year:");
                startYear.setBounds(25, 210, 100, 25);
                searchPanel.add(startYear);

                startYearText = new JTextField();
                startYearText.setBounds(170, 210, 100, 25);
                searchPanel.add(startYearText);

                JLabel endYear = new JLabel("End Year");
                endYear.setBounds(25, 280, 100, 25);
                searchPanel.add(endYear);

                endYearText = new JTextField();
                endYearText.setBounds(170, 280, 100, 25);
                searchPanel.add(endYearText);

                SearchResetButton = new JButton("Reset");
                SearchResetButton.setBounds(60, 70, 70, 40);
                SearchResetButton.addActionListener(new ResetListenerSearch());
                searchPanel2.add(SearchResetButton);

                searchButton = new JButton("Search");
                searchButton.setBounds(60, 250, 70, 40);
                searchButton.addActionListener(new SearchSearchListener());
                searchPanel2.add(searchButton);

                JLabel messLabel = new JLabel("Search Results:");
                messLabel.setBounds(10, 30, 100, 25);
                searchPanel3.add(messLabel);

                SearchBox = new JTextArea();
                SearchBox.setLineWrap(true);
                SearchBox.setWrapStyleWord(true);
                SearchBox.setOpaque(false);
                SearchBox.setEditable(false);
                SearchBox.setBorder(BorderFactory.createBevelBorder(1));
                SearchBox.setBackground(Color.GRAY); 
            
                JScrollPane messScrollPane = new JScrollPane(SearchBox);
                messScrollPane.setBounds(25, 60, 550, 140);
                messScrollPane.setBackground(Color.WHITE);
                messScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                messScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                searchPanel3.add(messScrollPane);

                add(searchPanel);
                add(searchPanel2);
                add(searchPanel3);
            }
        }
        // Action listener when user click the 'Reset' button
        private class ResetListenerSearch implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                idSearchText.setText("");
                descSearchText.setText("");
                startYearText.setText("");
                endYearText.setText("");
                SearchBox.setText("");
            }
            
        }
        // Action listener when user click the 'Search' button
        private class SearchSearchListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchBox.setText("");
                String id = "";
                String desc = "";
                int StartYear = 0;
                int EndYear = 0;

                // Below contains 3 try catch blocks to get the input from the text fields
                try{
                    id = idSearchText.getText();
                    if(id.isEmpty() == true){
                        id = "";
                    }else{
                        int tempId = Integer.parseInt(id);
                        if(id.length() != 6) throw new Exception();
                    }
                }catch(NumberFormatException a){
                    SearchBox.append("Please make sure ID is a number.\n");
                }catch(Exception a){
                    SearchBox.append("Please make sure ID has 6 digits\n");
                }

                desc = descSearchText.getText();
                if(desc.isEmpty() == true){
                    desc = "";
                }

                try{
                    String TempStartYear = startYearText.getText();
                    if(TempStartYear.isEmpty() == true){
                        StartYear = 0;
                    }else{
                        StartYear = Integer.parseInt(TempStartYear);
                        if(StartYear < 1000 || StartYear > 9999) throw new Exception();
                    }
                }catch(NumberFormatException a){
                    SearchBox.append("Please make sure Year is a number.\n");
                }catch(Exception a){
                    SearchBox.append("Please make sure 'Start Year' is between 1000-9999\n");
                }

                try{
                    String TempEndYear = endYearText.getText();
                    if(TempEndYear.isEmpty() == true){
                        EndYear = 0;
                    }else{
                        EndYear = Integer.parseInt(TempEndYear);
                        if(EndYear < 1000 || EndYear > 9999) throw new Exception();
                    }
                }catch(NumberFormatException a){
                    SearchBox.append("Please make sure Year is a number.\n");
                }catch(Exception a){
                    SearchBox.append("Please make sure 'Start Year' is between 1000-9999\n");
                }
                //call search() to search for the product.
                search(id, desc, StartYear, EndYear);
            }
        }
    }

    /**
    * If user select 'quit' from the menu bar
    * Before quiting, the program will write to the output file
    */
    private class QuitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(tempArgs.length == 1){
                fileOut(tempArgs);
            }
            System.exit(0);
        } 
    }

    /**
    * Constructer that makes up the frame
    * Include Menu Bar maker and welcome panel
    */
    public EStoreSearch(){
        super("eStoreSearch");
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenu commandBar = new JMenu("Commands");

        JMenuItem addChoice = new JMenuItem("add");
        addChoice.addActionListener(new AddListenter());
        commandBar.add(addChoice);
        
        JMenuItem searchChoice = new JMenuItem("search");
        searchChoice.addActionListener(new SearchListenter());
        commandBar.add(searchChoice);

        JMenuItem quitChoice = new JMenuItem("quit");
        quitChoice.addActionListener(new QuitListener());
        commandBar.add(quitChoice);

        JMenuBar bar = new JMenuBar();
        bar.setLayout(null);
        bar.add(commandBar);
        setJMenuBar(bar);

        welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0, 0, 600, 600);
        welcomePanel.setBackground(Color.WHITE);

        JTextArea text = new JTextArea(10, 40);
        text.setText("Welcome to eStoreSearch\n\n" + "Choose a command from the \"Commands\" menu above for adding a product, searching products, or quitting the program.");
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setBounds(10, 300, 400, 300);

        welcomePanel.add(text);
        add(welcomePanel);
    }

    /**
    * Function to put each words in the hash map
    */
    public static void hashing(){
        for(int i = 0; i < product.size(); i++){
            String buff = product.get(i).getDesc();
            String[] temp = buff.split("\\W+");
            for(int j = 0; j < temp.length; j++){
                temp[j] = temp[j].toLowerCase();
                if(map.containsKey(temp[j])){
                    ArrayList<Integer> buff2 = map.get(temp[j]);
                    buff2.add(i);
                    map.put(temp[j], buff2);
                }else{
                    ArrayList<Integer> newArr = new ArrayList<Integer>();
                    newArr.add(i);
                    map.put(temp[j], newArr);
                }
            }
        }
    }
    /**
    * convert integer arraylist to integer array
    * @param integers the integer arraylist
    * @return the converted arraylist in the form of integer array
    */
    public static Integer[] convertIntegers(ArrayList<Integer> integers){
        Integer[] ret = new Integer[integers.size()];
        ret = integers.toArray(new Integer[0]);
        return ret;
    }
    /**
    * method determine if user's keywords match any of the keys in the map 
    * @param keywords the user's keywords/description
    * @return the list of of the matches
    */
    public static ArrayList<String> foundKey(String keywords){
        String[] keys = keywords.split("\\W+");
        ArrayList<String> buff = new ArrayList<String>();
        for(int i = 0; i < keys.length; i++){
            if(map.containsKey(keys[i])){
                buff.add(keys[i]);
            }
        }
        return buff;
    }
    /**
    * method finds and returns the list of values(Arraylist of integer) that the keys are found 
    * @param keywords keywords from user
    * @param keys the arraylist of the matched keys from foundKeys
    * @return the integer list of the matched keys
    */
    public static ArrayList<Integer[]> integerList(String keywords, ArrayList<String> keys){
        ArrayList<Integer[]> intList = new ArrayList<Integer[]>(); 
        if(keys.size() != 0){
            for(int i = 0; i < keys.size(); i++){
                ArrayList<Integer> buff = map.get(keys.get(i));
                Integer[] temp = convertIntegers(buff); //convert arraylist integer to integer array
                intList.add(temp);
            }
        }
        return intList;
    }
    //method determine the intersection/union of 1, 2 or more integer arrays using HashSet
    public static Object[] intersectList(ArrayList<Integer[]> intList){
        HashSet<Integer> intersectSet = new HashSet<>(Arrays.asList(intList.get(0)));
        for(int i = 0; i < intList.size(); i++){
            HashSet<Integer> set = new HashSet<>(Arrays.asList(intList.get(i)));
            intersectSet.retainAll(set);
        }
        Object[] cool = intersectSet.toArray();
        return cool;
    }
    /**
    * Search for the product and append to the search text area
    * @param id input from the user or can be empty
    * @param desc keywords given by user or none
    * @param startYr beginning year
    * @param endYr end year
    */
    public static void search(String id, String desc, int startYr, int endYr){
        int[] descSet = {};
        if(!desc.isEmpty()){
            ArrayList<String> keys = foundKey(desc.toLowerCase());
            if(keys.size() != 0){
                ArrayList<Integer[]> intList = integerList(desc.toLowerCase(), keys);
                if(intList.size() != 0){
                    Object[] arr = intersectList(intList);
                    descSet = new int[arr.length];

                    for(int i=0; i<arr.length; i++){
                        descSet[i] = (int) arr[i];
                    }
                }
            }
        }

        int initial = 0; // the beginning of the period of time
        int end = 0;//the ending of the period of time 
        int count = 0; //keep count of how many matches the method found

        //assigning beginning and endind of the period base of where the dash '-' is
        if(startYr != 0 && endYr == 0){
            initial = startYr;
            end = 9999;
        }
        if(startYr == 0 && endYr != 0){
            initial = 1000;
            end = endYr;
        }
        if(startYr == 0 && endYr == 0){
            initial = 1000;
            end = 9999;
        }
        if(startYr != 0 && endYr != 0){
            initial = startYr;
            end = endYr;
        }

        if(id.isEmpty() && desc.isEmpty() && (startYr != 0 || endYr != 0)){ //ID and keywords are empty
            for(int i = 0; i < product.size(); i++){
                //convert a String into an integer for comparing purpose
                int temp = product.get(i).getYear(); 
                if(temp >= initial && temp <= end){//check if any year in the ArrayList falls in betweent the period of time
                    append(i);//A method written below to print out the matched product 
                    count++;//update the amount of matches
                }
            }
        }
        if(id.isEmpty() && !desc.isEmpty() && descSet.length != 0 && (startYr != 0 || endYr != 0)){ //Only ID is empty
            for(int i = 0; i < descSet.length; i++){
                int temp = product.get(descSet[i]).getYear();
                if(temp >= initial && temp <= end){
                    append(i);
                    count++;
                }
            }
        }
        if(desc.isEmpty() && !id.isEmpty() && (startYr != 0 || endYr != 0)){//Only Description is empty
            for(int i = 0; i < product.size(); i++){
                int temp = product.get(i).getYear();
                //check if any product falls in the year period and contains the given keywords
                if((temp >= initial && temp <= end) && (product.get(i).getID().equals(id))){
                    append(i);
                    count++;
                }
            }
        }
        if((startYr != 0 || endYr != 0) && !id.isEmpty() && !desc.isEmpty() && descSet.length != 0){//The user provide everything(year, description, ID)
            for(int i = 0; i < descSet.length; i++){
                int temp = product.get(i).getYear();
                String idTemp = product.get(descSet[i]).getID();
                if((temp >= initial && temp <= end) && (idTemp.equals(id))){
                    append(i);
                    count++;
                }
            }
        }
        //if year is empty, use the other method that use a specific year
        if((startYr == 0 && endYr == 0) && desc.isEmpty() && !id.isEmpty()){
            for(int i = 0; i < product.size(); i++){
                //Find the product with matched ID
                if(product.get(i).getID().equals(id)){
                    append(i);
                    count++;
                }
            }
        }
        if(id.isEmpty() && (startYr == 0 && endYr == 0) && !desc.isEmpty()){
            for(int i = 0; i < descSet.length; i++){
                append(descSet[i]);
                count++;
            }
        }
        if((startYr == 0 && endYr == 0) && !id.isEmpty() && !desc.isEmpty()){
            for(int i = 0; i < descSet.length; i++){
                String idTemp = product.get(descSet[i]).getID();
                if(idTemp.equals(id)){
                    append(descSet[i]);
                    count++;
                }
            }
        }
        if((startYr == 0 && endYr == 0) && id.isEmpty() && desc.isEmpty()){//all are empty
            //print every products out
            for(int i = 0; i < product.size(); i++){
                append(i);
                count++;
            }
        }
        //if e variable does not change, that means that there were no product found
        else if(count == 0){
            SearchBox.append("No product found.");
        }
    }
    /**
    * Add products to the ArrayList from the input file
    * @param args input from command line
    */
    public static void addFile(String[] args){
        Scanner inputFile = null;
        String array[] = new String[10000];
        int j = 0;
        String file[] = new String[5];
        //gets the input file if there is one
        for (String arg : args) {
            file = args;
        }
        //if there is a file put in by the user
        if (file[0] != null) {
            try {
                inputFile = new Scanner (new FileInputStream(file[0]));
            }catch (FileNotFoundException e) {
                SearchBox.append("Error opening the input file");
            }
            //put the file input to a array to be read later
            while (inputFile.hasNextLine()) {
                array[j] = inputFile.nextLine();
                j++;
            }
            inputFile.close();
            for (int i = 0; i < j; i++) {
                if (array[i].contains("type") || array[i].contains("Type")) {
                    //if the file line has a b for book in it
                    if (array[i].charAt(8) == 'b' || array[i].charAt(8) == 'B') {
                        String id[] = array[i+1].split("\"|=|\\s+ ");
                        String description[] = array[i+2].split("\"|=|\\s+ ");
                        String tempPrice[] = array[i+3].split("\"|=|\\s+ ");
                        String tempYear[] = array[i+4].split("\"|=|\\s+ ");
                        String author[] = array[i+5].split("\"|=|\\s+ ");
                        String publisher[] = array[i+6].split("\"|=|\\s+ ");
                        double price = Double.parseDouble(tempPrice[2]);
                        int year = Integer.parseInt(tempYear[2]);
                        
                        try{
                            product.add(new Book (id[2], description[2], price, year, author[2], publisher[2]));
                            hashing();
                        } catch(Exception e){
                            System.out.println("One of the mandatory information is missing");
                        }
                        i += 6;
                        //if the file line has an e for electronic in it
                    } 
                    else if (array[i].charAt(8) == 'e' || array[i].charAt(8) == 'E') {
                        String id[] = array[i+1].split("\"|=|\\s+ ");
                        String description[] = array[i+2].split("\"|=|\\s+ ");
                        String tempPrice[] = array[i+3].split("\"|=|\\s+ ");
                        String tempYear[] = array[i+4].split("\"|=|\\s+ ");
                        String maker[] = array[i+5].split("\"|=|\\s+ ");

                        double price = Double.parseDouble(tempPrice[2]);
                        int year = Integer.parseInt(tempYear[2]);
                        try{
                            product.add(new Electronic (id[2], description[2], price, year, maker[2]));
                            hashing();
                        } catch(Exception e){
                            System.out.println("One of the mandatory information is missing");
                        }
                        i += 5;
                    }
                }
            }
        }
    }
    /**
    * Write out to the given input file
    * @param args user input from command line
    */
    public static void fileOut(String[] args)
    {
        PrintWriter outputStream = null; 
        if(product.size() != 0){
            try{
                outputStream = new PrintWriter(new FileOutputStream(args[0]));
            }catch(FileNotFoundException e){
                System.out.println("Error opening the file or file not found");
            }
            for(int x = 0; x < product.size(); x++){
                outputStream.println(product.get(x).output());
            } 
            System.out.println("All info has been parsed to a designated file");
            
            outputStream.close();
        }
    }

    /**
    * Check if ID already existed in the system
    * @param id from user text field
    * @return true or false, true if product doesnt exist in the system and false if the product already existed
    */
    public static boolean idCheck(String id){
        for(int i = 0; i < product.size(); i++){
            if(product.get(i).getID() == id){
                return false;
            }
        }
        return true;
    }

    /**
    * Append the product information to the search text area
    * @param i
    */
    public static void append(int i){
        SearchBox.append("\n----------------------\n");
        SearchBox.append(product.get(i).toString());
        SearchBox.append("\n----------------------\n");
    }
    
    public static void main(String[] args){
        tempArgs = args;
        if(tempArgs.length == 1){
            addFile(args);
        }
        EStoreSearch gui = new EStoreSearch();
        gui.setVisible(true);
    }
}