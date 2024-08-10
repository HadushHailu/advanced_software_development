package counter;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JFrameCounter extends JFrame {
    private JButton jButtonIncrement = new JButton();
    private JButton jButtondecrement = new JButton();
    private JButton jButtonundo = new JButton();
    private JButton jButtonredo = new JButton();
    
    private Counter counter;
    private HistoryList historyList = new HistoryList();
    private CountObservable countObservable = new CountObservable();

    ICountObserver iCountObserver1 = new RectFrame();
    ICountObserver iCountObserver2 = new TextFrame();
    ICountObserver iCountObserver3 = new OvalFrame();

    public JFrameCounter() {
        try {
            jbInit();
            counter = new Counter();
            iCountObserver1.setVisible(true);
            iCountObserver2.setVisible(true);
            iCountObserver3.setVisible(true);
            counter.setTextframe(iCountObserver1);
            counter.setRectframe(iCountObserver2);
            counter.setOvalframe(iCountObserver3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	JFrameCounter frame = new JFrameCounter();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);

        //initialize observers
        frame.initObservers();
    }

    private void initObservers(){
        countObservable.addObserver(iCountObserver1);
        countObservable.addObserver(iCountObserver2);
        countObservable.addObserver(iCountObserver3);
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(297, 169));
        jButtonIncrement.setText("+");
        jButtonIncrement.setBounds(new Rectangle(30, 25, 73, 22));
        jButtonIncrement.setActionCommand("increment");
        jButtonIncrement.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButtonIncrement_actionPerformed(e);
                    }
                });
        jButtondecrement.setText("-");
        jButtondecrement.setBounds(new Rectangle(155, 25, 73, 22));
        jButtondecrement.setActionCommand("decrement");
        jButtondecrement.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButtondecrement_actionPerformed(e);
                    }
                });
        jButtonundo.setText("undo");
        jButtonundo.setBounds(new Rectangle(30, 80, 73, 22));
        jButtonundo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButtonundo_actionPerformed(e);
                    }
                });
        jButtonredo.setText("redo");
        jButtonredo.setBounds(new Rectangle(155, 80, 73, 22));
        jButtonredo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButtonredo_actionPerformed(e);
                    }
                });
        this.getContentPane().add(jButtonredo, null);
        this.getContentPane().add(jButtonundo, null);
        this.getContentPane().add(jButtondecrement, null);
        this.getContentPane().add(jButtonIncrement, null);
    }

    private void jButtonIncrement_actionPerformed(ActionEvent e) {
        //strategy pattern
        ICommand iCommand = new incrementCommand(counter);
        iCommand.execute();
        historyList.addCommand(iCommand);

        //observer pattern
        countObservable.update(counter.getCount());
    }

    private void jButtondecrement_actionPerformed(ActionEvent e) {
        //strategy pattern
        ICommand iCommand = new decrementCommand(counter);
        iCommand.execute();
        historyList.addCommand(iCommand);
        //observer pattern
        countObservable.update(counter.getCount());
    }

    private void jButtonundo_actionPerformed(ActionEvent e) {
    	System.out.println("undo");
        historyList.undo();
    }

    private void jButtonredo_actionPerformed(ActionEvent e) {
    	System.out.println("redo");
        historyList.redo();
    }
}
