import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class test2 extends JFrame implements ActionListener, ComponentListener, MouseListener {
    JMenuBar menuBar;
    JPanel textPanel;

    public test2() {
        //set up the Frame
        setTitle("Simple Text Editor");
        setLayout(null);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        UIManager.put("Menu.selectionBackground", Color.LIGHT_GRAY);

        //create the menu bar
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, getWidth(), 25);
        menuBar.setBackground(Color.WHITE);
        menuBar.setFont(new Font("Arial", Font.PLAIN, 14));
        add(menuBar);

        //create the menus
        JMenu fileMenu = new JMenu(" File ");
        JMenu editMenu = new JMenu(" Edit ");
        JMenu formatMenu = new JMenu(" Format ");
        JMenu helpMenu = new JMenu(" Help ");
        fileMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        editMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        formatMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        helpMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(helpMenu);
        fileMenu.addMouseListener(this);
        editMenu.addMouseListener(this);
        formatMenu.addMouseListener(this);
        helpMenu.addMouseListener(this);

        //create an editable text pane
        JTextPane textPane = new JTextPane();
        Font font = new Font("Helventica", Font.PLAIN, 14);
        textPane.setFont(font);
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
        textPane.setCharacterAttributes(attributeSet, true);
        textPane.setEditable(true);
        String testString = "";
        textPane.setText(testString);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBounds(0, 25, getWidth() - 16, getHeight() - 71);
        textPanel.add(scrollPane);
        add(textPanel);

        addComponentListener(this);

        setVisible(true);
    }

    public static void main(String[] args){
        test2 a = new test2();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        menuBar.setBounds(0, 0, getWidth(), 25);
        textPanel.setBounds(0, 25, getWidth() - 16, getHeight() - 71);
        revalidate();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        arg0.getComponent().setFont(new Font("Arial", Font.BOLD, 14));
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        arg0.getComponent().setFont(new Font("Arial", Font.PLAIN, 14));
    }

    //unimplemented methods
    @Override
    public void actionPerformed(ActionEvent arg0) {}

    @Override
    public void componentHidden(ComponentEvent e) {}

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}
}
