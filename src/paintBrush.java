import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class paintBrush extends JPanel implements MouseMotionListener, MouseListener {
    public static int screenX = -5000;
    public static int screenXM = 5000;
    public static int screenY = -5000;
    public static int screenYM = 5000;
    private Color filledColor = Color.WHITE;
    private Graphics2D g2;
    public static Image image;
    private int confirm;
    private boolean firstEnter = true;
    int x2;
    int y2;
    int x1;
    int y1;

    public paintBrush() {
        this.setBackground(Color.white);
        this.setBounds(screenX, screenY, 10000, 10000);
        this.setLayout(null);
        this.setVisible(false);
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(new keyListener());
    }
    public void paintComponent(Graphics g) {
        this.setBounds(screenX, screenY, 10000, 10000);
        Menu.buttonPos();
        if (image == null) {
            File file = new File("savedBoards/"+Menu.boardName+".jpeg");
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                System.out.println("Creating new Note with the name "+Menu.boardName);
                image = createImage(getWidth(), getHeight());
            }
            g2 = (Graphics2D) image.getGraphics();
            firstEnter = false;
        }
        g.drawImage(image, 0, 0, null);

    }

    public void clearPage() {
        if (!firstEnter)
            confirm = JOptionPane.showConfirmDialog(null, "WARNING\nAre you sure you want to clear Canvas? Its NOT recoverable", "Clear Warning", JOptionPane.OK_CANCEL_OPTION);
        if (confirm != 0) {
            return;
        }
        g2.setPaint(Menu.board.getBackground());
        g2.fillRect(0, 0, 19200, 10800);
        g2.setColor(Menu.brushColor);
        filledColor = Color.white;
        if (Menu.mathGrid)
            setGrid();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (g2 != null) {
            g2.setStroke(new BasicStroke(Menu.stroke));
            g2.setPaint(Menu.brushColor);
            if (Menu.eraserOpen) {
                g2.setStroke(new BasicStroke(Menu.stroke + 4));
                g2.setPaint(filledColor);
            }
            g2.fillOval(e.getX(), e.getY(), Menu.stroke, Menu.stroke);
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Menu.mathGrid && Menu.eraserOpen) {
            setGrid();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        if (Menu.screenMove || keyListener.cntrl) {
            if (x1 > e.getX()) {
                screenX = screenX - 6;
                screenXM = screenXM + 6;
            }
            if (x1 < e.getX()) {
                screenX = screenX + 6;
                screenXM = screenXM - 6;
            }
            if (y1 > e.getY()) {
                screenY = screenY - 6;
                screenYM = screenYM + 6;
            }
            if (y1 < e.getY()) {
                screenY = screenY + 6;
                screenYM = screenYM - 6;
            }
            Menu.colorSetUp();
            repaint();
            return;
        }
        if (g2 != null) {
            g2.setStroke(new BasicStroke(Menu.stroke));
            g2.setPaint(Menu.brushColor);
            if (Menu.eraserOpen) {
                g2.setStroke(new BasicStroke(Menu.stroke + 10));
                Menu.eraserMouseImage.setBounds(e.getX(), e.getY(), 30, 30);
                g2.setPaint(filledColor);
            }
            g2.drawLine(x1, y1, x2, y2);
        }
        repaint();
        x1 = x2;
        y1 = y2;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (Menu.eraserOpen) {
            Menu.eraserMouseImage.setBounds(e.getX(), e.getY(), 30, 30);
        }
    }

    public void setGrid() {
        Color color = Color.BLACK;
        if (filledColor == Color.BLACK) {
            color = Color.WHITE;
        }
        g2.setStroke(new BasicStroke(2));
        g2.setPaint(color);
        for (int x = 0; x <= this.getWidth(); x += 35) {
            g2.drawLine(x, 0, x, this.getHeight());
        }
        for (int y = 0; y <= this.getHeight(); y += 35) {
            g2.drawLine(0, y, this.getWidth(), y);
        }
        g2.setStroke(new BasicStroke(Menu.stroke));
        g2.setColor(Menu.brushColor);
        repaint();
    }

    public void fillPage(Color pageColor) {
        g2.setColor(pageColor);
        g2.fillRect(0, 0, 10000, 10000);
        filledColor = pageColor;
        if (Menu.mathGrid)
            setGrid();
        repaint();
    }
}