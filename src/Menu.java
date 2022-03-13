import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Menu extends JPanel implements ActionListener {
    saveBoard saveboard = new saveBoard();
    public static Color brushColor = Color.black;
    public static int stroke = 4;
    public static String boardName;
    public static boolean brushOpen = false, thicknessIsOpen = false;
    public static boolean eraserOpen = false;
    public static boolean mathGrid = false;
    public static boolean screenMove = false;
    public static boolean fillOpen = false;
    static boolean equippedBrush = false;
    static boolean equippedEraser = false;
    private boolean thicknessWasOpen = false;
    private int buttonY = 0;
    private int buttonX = 0;
    private int saveCounter = 0;

    JPanel menu = new JPanel();
    JButton red = new JButton();
    JButton orange = new JButton();
    JButton yellow = new JButton();
    JButton green = new JButton();
    JButton blue = new JButton();
    JButton magenta = new JButton();
    JButton grey = new JButton();
    JButton black = new JButton();
    JButton white = new JButton();
    JButton pink = new JButton();
    JButton cyan = new JButton();
    JButton darkRed = new JButton();
    static ArrayList<JButton> buttonsTempNotVisible = new ArrayList<>();
    static ArrayList<JButton> allButtons = new ArrayList<>();
    static ArrayList<JButton> allSaveButtons = new ArrayList<>();
    static ArrayList<JLabel> labelsTempNotVisible = new ArrayList<>();
    static ArrayList<JLabel> allLabels = new ArrayList<>();
    static ArrayList<JButton> colorButtons = new ArrayList<>();
    static JButton options = new JButton();
    static JButton gridLines = new JButton();
    static JButton screenMovement = new JButton();
    static JButton mainMenu = new JButton();
    static JButton canvasButton = new JButton();
    static JButton brush = new JButton();
    static JButton thickness = new JButton();
    static JButton thickness1 = new JButton();
    static JButton thickness2 = new JButton();
    static JButton thickness3 = new JButton();
    static JButton thickness4 = new JButton();
    static JButton save = new JButton();
    static JButton reload = new JButton();
    static JButton clear = new JButton();
    static JButton eraser = new JButton();
    static JButton fillPage = new JButton();
    static JButton delete = new JButton();
    static JButton newCanvas = new JButton();
    boolean open = false;
    //
    static JLabel menuImage = new JLabel();
    static JLabel brushImage = new JLabel();
    static JLabel eraserImage = new JLabel();
    public static JLabel eraserMouseImage = new JLabel();
    public static JLabel bucketImage = new JLabel();
    static ImageIcon menuImageIcon = new ImageIcon("Images/Menu.jpg");
    ImageIcon brushImageIcon = new ImageIcon("Images/brush.png");
    ImageIcon eraserImageIcon = new ImageIcon("Images/eraser.png");
    ImageIcon eraserImageMouseIcon = new ImageIcon("Images/eraserMouse.png");
    ImageIcon bucketImageIcon = new ImageIcon("Images/bucket.png");
    public static paintBrush board = new paintBrush();
    public static Color dr = new Color(0xB20101);
    Color tools = new Color(0x7242A9);


    public Menu() {
        Main.frame.add(menu);
        Main.frame.add(board);
        menu.addKeyListener(new keyListener());
        board.setVisible(false);
        board.setLayout(null);
        menu.setLayout(null);
        buttonSetUp(red, 20, "Red", Color.red, false, 0, 0, 0, 0, board);
        buttonSetUp(orange, 20, "Orange", Color.orange, false, 0, 0, 0, 0, board);
        buttonSetUp(yellow, 20, "Yellow", Color.yellow, false, 0, 0, 0, 0, board);
        buttonSetUp(green, 20, "Green", Color.green, false, 0, 0, 0, 0, board);
        buttonSetUp(blue, 20, "Blue", Color.blue, false, 0, 0, 0, 0, board);
        buttonSetUp(magenta, 20, "Magenta", Color.magenta, false, 0, 0, 0, 0, board);
        buttonSetUp(grey, 20, "Gray", Color.gray, false, 0, 0, 0, 0, board);
        buttonSetUp(black, 20, "Black", Color.black, false, 0, 0, 0, 0, board);
        buttonSetUp(white, 20, "White", Color.white, false, 0, 0, 0, 0, board);
        buttonSetUp(pink, 20, "Pink", Color.pink, false, 0, 0, 0, 0, board);
        buttonSetUp(cyan, 20, "Cyan", Color.cyan, false, 0, 0, 0, 0, board);
        buttonSetUp(darkRed, 20, "Dark Red", dr, false, 0, 0, 0, 0, board);
        buttonSetUp(thickness1, 20, "2", Color.lightGray, false, paintBrush.screenXM + 300, paintBrush.screenYM + 850, 65, 20, board);
        buttonSetUp(thickness2, 20, "4", Color.lightGray, false, paintBrush.screenXM + 300, paintBrush.screenYM + 880, 65, 25, board);
        buttonSetUp(thickness3, 20, "6", Color.lightGray, false, paintBrush.screenXM + 300, paintBrush.screenYM + 915, 65, 35, board);
        buttonSetUp(thickness4, 20, "8", Color.lightGray, false, paintBrush.screenXM + 300, paintBrush.screenYM + 960, 65, 40, board);
        colorButtons.add(red);
        colorButtons.add(orange);
        colorButtons.add(yellow);
        colorButtons.add(green);
        colorButtons.add(blue);
        colorButtons.add(magenta);
        colorButtons.add(grey);
        colorButtons.add(black);
        colorButtons.add(white);
        colorButtons.add(pink);
        colorButtons.add(cyan);
        colorButtons.add(darkRed);
        colorSetUp();
        buttonSetUp(options, 15, "O", tools, true, paintBrush.screenXM + 1880, paintBrush.screenYM + 990, 30, 30, board);
        buttonSetUp(gridLines, 15, "G", tools, true, paintBrush.screenXM + 1880, paintBrush.screenYM + 920, 30, 60, board);
        buttonSetUp(brush, 15, "Brush", tools, false, paintBrush.screenXM + 400, paintBrush.screenYM + 880, 200, 200, board);
        buttonSetUp(screenMovement, 15, "Hand", tools, false, paintBrush.screenXM + 1450, paintBrush.screenYM + 880, 200, 200, board);
        buttonSetUp(eraser, 15, "Eraser", tools, false, paintBrush.screenXM + 610, paintBrush.screenYM + 880, 200, 200, board);
        buttonSetUp(clear, 15, "Clear Canvas", tools, false, paintBrush.screenXM + 820, paintBrush.screenYM + 880, 200, 200, board);
        buttonSetUp(thickness, 15, "Thickness", tools, false, paintBrush.screenXM + 1030, paintBrush.screenYM + 880, 200, 200, board);
        buttonSetUp(fillPage, 15, "Fill Page", tools, false, paintBrush.screenXM + 1240, paintBrush.screenYM + 880, 200, 200, board);
        buttonSetUp(mainMenu, 18, "Main Menu", tools, false, paintBrush.screenXM + 1710, paintBrush.screenYM + 30, 200, 30, board);
        buttonSetUp(save, 18, "Save", tools, false, paintBrush.screenXM + 1710, paintBrush.screenYM + 70, 200, 30, board);
        buttonSetUp(reload, 18, "Reload", tools, false, paintBrush.screenXM + 1710, paintBrush.screenYM + 110, 200, 30, board);
        //Canvas Button:
        buttonSetUp(canvasButton, 40, "Canvas", new Color(0xE73333), true, 50, 70, 405, 85, menu);
        buttonSetUp(newCanvas, 15, "New Canvas", new Color(0xE73333), true, 50, 20, 200, 40, menu);
        lastSaves(true);
        board.setBackground(Color.white);
        board.setBounds(0, 0, 1920, 1080);
        menu.setBounds(0, 0, 1920, 1080);
        menu.add(menuImage);
        menuImage.setIcon(menuImageIcon);
        menuImage.setBounds(1120, 0, 800, 500);
        menu.setVisible(true);
        eraserMouseImage.addKeyListener(new keyListener());
        brushImage.addKeyListener(new keyListener());
        eraserImage.addKeyListener(new keyListener());
        bucketImage.addKeyListener(new keyListener());
        //brush image
        board.add(brushImage);
        brushImage.setIcon(brushImageIcon);
        brushImage.setBounds(paintBrush.screenXM + 20, 20, 30, 30);
        //bucket image
        board.add(bucketImage);
        bucketImage.setIcon(bucketImageIcon);
        bucketImage.setBounds(paintBrush.screenXM + 10, 20, 30, 30);
        //eraser image
        board.add(eraserImage);
        board.add(eraserMouseImage);
        eraserImage.setIcon(eraserImageIcon);
        eraserMouseImage.setIcon(eraserImageMouseIcon);
        eraserImage.setBounds(paintBrush.screenXM + 10, 20, 30, 30);
        //
        allLabels.add(brushImage);
        allLabels.add(eraserImage);
        allLabels.add(eraserMouseImage);
        allLabels.add(bucketImage);
        //
        brushImage.setVisible(equippedBrush);
        eraserImage.setVisible(equippedEraser);
        bucketImage.setVisible(false);
        brushImage.addKeyListener(new keyListener());
        mainMenu.addKeyListener(new keyListener());
        eraserMouseImage.addKeyListener(new keyListener());
        eraserMouseImage.setBounds(paintBrush.screenXM + 40, 50, 30, 30);
        eraserMouseImage.setVisible(true);
        board.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        menu.setBackground(Color.white);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "Red": {
                brushColor = Color.red;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Orange": {
                brushColor = Color.orange;
                if (fillOpen) board.fillPage(brushColor);
                     break;
            }
            case "Yellow": {
                brushColor = Color.yellow;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Green" : {
                brushColor = Color.green;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Blue" : {
                brushColor = Color.blue;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Magenta" :{
                brushColor = Color.magenta;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Black" : {
                brushColor = Color.black;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "White" : {
                brushColor = Color.white;
                if (fillOpen) board.fillPage(brushColor);
            break;
            }
            case "Pink" :{
                brushColor = Color.pink;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Cyan" : {
                brushColor = Color.cyan;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Gray" : {
                brushColor = Color.gray;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "Dark Red" : {
                brushColor = dr;
                if (fillOpen) board.fillPage(brushColor);
                break;
            }
            case "2" : stroke = 2; break;
            case "4" : stroke = 4; break;
            case "6" : stroke = 6; break;
            case "8" : stroke = 8; break;
            case "Canvas" : {
                if (boardName == null) {
                    boardName = JOptionPane.showInputDialog("Please Enter The Name Of The Project");
                    break;
                }
                save.setVisible(true);
                reload.setVisible(true);
                mainMenu.setVisible(true);
                menu.setVisible(false);
                board.setVisible(true);
            }
            case "Clear Canvas" : board.clearPage(); break;

            case "New Canvas" : {
                Menu.boardName = null;
                boardName = JOptionPane.showInputDialog("Please Enter The Name Of The Project");
                paintBrush.image = null;
                save.setVisible(true);
                reload.setVisible(true);
                mainMenu.setVisible(true);
                menu.setVisible(false);
                board.setVisible(true);
                break;
            }

            case "Fill Page" :{
                if (!fillOpen) {
                    colorShow(true);
                    fillOpen = true;
                    bucketImage.setVisible(true);

                } else {
                    colorShow(false);
                    fillOpen = false;
                }
                colorShow(true);
                equippedBrush = false;
                equippedEraser = false;
                equipped();
                board.repaint();
                break;
            }
            case "Main Menu" : {
                colorShow(false);
                board.setVisible(false);
                screenMovement.setVisible(false);
                thickness1.setVisible(false);
                fillOpen = false;
                brushOpen = false;
                thickness2.setVisible(false);
                thickness3.setVisible(false);
                thickness4.setVisible(false);
                brush.setVisible(false);
                thickness.setVisible(false);
                clear.setVisible(false);
                eraser.setVisible(false);
                fillPage.setVisible(false);
                mainMenu.setVisible(false);
                reload.setVisible(false);
                save.setVisible(false);
                open = false;
                delete.setVisible(true);
                canvasButton.setVisible(true);
                menu.setVisible(true);
                break;
            }
            case "Brush" : {
                screenMove = false;
                bucketImage.setVisible(false);
                fillOpen = false;
                equippedEraser = false;
                equippedBrush = true;
                equipped();
                eraserOpen = false;
                if (!brushOpen) {
                    colorShow(true);
                    brushOpen = true;
                } else {
                    colorShow(false);
                    brushOpen = false;
                }
                board.repaint();
                break;
            }
            case "Eraser" :{
                screenMove = false;
                bucketImage.setVisible(false);
                fillOpen = false;
                colorShow(false);
                equippedBrush = false;
                equippedEraser = true;
                equipped();
                if (!eraserOpen) {
                    eraserMouseImage.setVisible(true);
                    brushOpen = false;
                    eraserOpen = true;
                }
                break;
            }

            case "G" : {
                if (mathGrid) {
                    mathGrid = false;
                } else {
                    mathGrid = true;
                    board.setGrid();
                }
                break;
            }
            case "Save" : {
                if (!saveboard.contains(boardName)){
                    saveBoard.saveGetAll();
                    saveBoard.savedNotes.add(boardName);
                    lastSaves(false);
                }
                saveboard.saveBoardData(board);
                allComponentsRetrieveVisibility();
                saveboard.addSave();
                break;
            }
            case "Reload":  {
                paintBrush.image = null;
                board.repaint();
                break;
            }

            case "O" : {
                if (open) {
                    fillOpen = false;
                    brush.setVisible(false);
                    screenMovement.setVisible(false);
                    thickness.setVisible(false);
                    clear.setVisible(false);
                    eraser.setVisible(false);
                    fillPage.setVisible(false);
                    save.setVisible(true);
                    reload.setVisible(true);
                    brushOpen = false;
                    thicknessIsOpen = false;
                    colorShow(false);
                    thickness1.setVisible(false);
                    thickness2.setVisible(false);
                    thickness3.setVisible(false);
                    thickness4.setVisible(false);
                    open = false;
                    return;
                }
                screenMovement.setVisible(true);
                brush.setVisible(true);
                thickness.setVisible(true);
                clear.setVisible(true);
                eraser.setVisible(true);
                fillPage.setVisible(true);
                open = true;
                break;
            }
            case "Hand" : {
                if (screenMove) {
                    screenMove = false;
                    if (thicknessWasOpen) {
                        thicknessIsOpen = true;
                        thicknessShow(true);
                    }
                    brushOpen = true;
                    colorShow(true);
                } else {
                    screenMovement.setVisible(true);
                    screenMove = true;
                    brushOpen = false;
                    thicknessIsOpen = false;
                    thicknessShow(false);
                    colorShow(false);
                }
                break;
            }

            case "Thickness" : {
                if (!thicknessIsOpen) {
                    thicknessShow(true);
                    thicknessIsOpen = true;
                    thicknessWasOpen = true;
                } else {
                    thicknessIsOpen = false;
                    thicknessShow(false);
                    thicknessWasOpen = false;
                }
                break;
            }
            default : {
                int counter = 0;
                saveBoard.saveGetAll();
                for (String u : saveBoard.savedNotes) {
                    if (action.equals(u)) {
                        boardName = u;
                        System.out.println("Board Name: " + boardName);
                        if (saveBoard.savedGrid.get(counter).equals("true")) {
                            mathGrid = true;
                            System.out.println("Math Grid: True");
                        }
                        paintBrush.image = null;
                        board.repaint();
                        return;
                    }
                    counter += 1;
                }
            }
        }
    }

    public static void allComponentsNotVisible() {
        for (JButton button : allButtons) {
            if (button.isVisible()) {
                buttonsTempNotVisible.add(button);
                button.setVisible(false);
            }
        }
        for (JLabel label : allLabels) {
            if (label.isVisible()) {
                label.setVisible(false);
                labelsTempNotVisible.add(label);
            }
        }
    }

    private void allComponentsRetrieveVisibility() {
        for (JButton button : buttonsTempNotVisible) {
            button.setVisible(true);
        }
        for (JLabel label : labelsTempNotVisible) {
            label.setVisible(true);
        }
    }

    private void thicknessShow(boolean visible) {
        thickness1.setVisible(visible);
        thickness2.setVisible(visible);
        thickness3.setVisible(visible);
        thickness4.setVisible(visible);
    }

    public static void equipped() {
        brushImage.setVisible(equippedBrush);
        eraserImage.setVisible(equippedEraser);
        bucketImage.setVisible(fillOpen);
        if (!equippedEraser) {
            eraserMouseImage.setVisible(false);
        }
    }//
    public static void buttonPos() {
        save.setBounds(paintBrush.screenXM + 1710, paintBrush.screenYM + 70, 200, 30);
        reload.setBounds(paintBrush.screenXM + 1710, paintBrush.screenYM + 110, 200, 30);
        gridLines.setBounds(paintBrush.screenXM + 1880, paintBrush.screenYM + 920, 30, 60);
        thickness1.setBounds(paintBrush.screenXM + 300, paintBrush.screenYM + 850, 65, 20);
        thickness2.setBounds(paintBrush.screenXM + 300, paintBrush.screenYM + 880, 65, 25);
        thickness3.setBounds(paintBrush.screenXM + 300, paintBrush.screenYM + 915, 65, 35);
        thickness4.setBounds(paintBrush.screenXM + 300, paintBrush.screenYM + 960, 65, 40);
        bucketImage.setBounds(paintBrush.screenXM + 10, paintBrush.screenYM + 20, 30, 30);
        brushImage.setBounds(paintBrush.screenXM + 20, paintBrush.screenYM + 20, 30, 30);
        eraserImage.setBounds(paintBrush.screenXM + 10, paintBrush.screenYM + 20, 30, 30);
        options.setBounds(paintBrush.screenXM + 1880, paintBrush.screenYM + 990, 30, 30);
        brush.setBounds(paintBrush.screenXM + 400, paintBrush.screenYM + 880, 200, 200);
        fillPage.setBounds(paintBrush.screenXM + 1240, paintBrush.screenYM + 880, 200, 200);
        screenMovement.setBounds(paintBrush.screenXM + 1450, paintBrush.screenYM + 880, 200, 200);
        eraser.setBounds(paintBrush.screenXM + 610, paintBrush.screenYM + 880, 200, 200);
        clear.setBounds(paintBrush.screenXM + 820, paintBrush.screenYM + 880, 200, 200);
        thickness.setBounds(paintBrush.screenXM + 1030, paintBrush.screenYM + 880, 200, 200);
        mainMenu.setBounds(paintBrush.screenXM + 1710, paintBrush.screenYM + 30, 200, 30);
    }

    public void buttonSetUp(JButton button, int fontSize, String text, Color color, Boolean visible, int x, int y, int z, int w, JPanel panel) {
        button.setBounds(x, y, z, w);
        button.setFont(new Font("Dialog", Font.BOLD, fontSize));
        button.setBackground(color);
        button.setText(text);
        panel.add(button);
        button.addActionListener(this);
        button.addKeyListener(new keyListener());
        button.setVisible(visible);
        allButtons.add(button);

    }

    public static void colorSetUp() {
        int x = paintBrush.screenXM, y = paintBrush.screenYM + 790;
        int w = 50, h = 50;
        int counter = 0;
        for (JButton button : colorButtons) {
            x = x + 60;
            if (counter % 4 == 0) {
                y += 60;
                x = paintBrush.screenXM + 60;
            }
            counter += 1;
            button.setBounds(x, y, w, h);
        }
    }

    public static void colorShow(boolean visible) {
        for (JButton button : colorButtons) {
            button.setVisible(visible);
        }
    }

    private void lastSaves(boolean firstLogin) {
        if (firstLogin){
            saveBoard.saveGetAll();
            buttonY = 90;
            buttonX = 50;
        }
        if (!firstLogin){
        saveCounter = saveBoard.savedNotes.size() -1;
        }

        Color c = new Color(0x286528);
        while (saveCounter < saveBoard.savedNotes.size()) {
            String s = saveBoard.savedNotes.get(saveCounter);
            if (saveCounter % 10 == 0 && saveCounter != 0) {
                buttonX += 205;
                buttonY = 90;
            }
            buttonY += 70;
            JButton a = new JButton(s);
            menu.add(a);
            a.setBounds(buttonX, buttonY, 200, 65);
            System.out.println(s + "' X: " + a.getX() + "\n" + s + "' Y: " + a.getY());
            a.setForeground(Color.WHITE);
            a.setBackground(c);
            a.addActionListener(this);
            allSaveButtons.add(a);
            saveCounter += 1;
        }

    }
}
