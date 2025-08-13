package ch15;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.sound.midi.ShortMessage.*;

public class BeatBox {
//Store JCheckBoxes in an ArrayList    

    private ArrayList<JCheckBox> checkboxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

//The instrument names as a String array that will be used for building
//GUI labels on each row  
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
        "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
        "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
        "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
        "Open Hi Conga"};
//Numbers that represent the type of drum  
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    public void buildGUI() {
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();

        JPanel background = new JPanel(layout);

//Empty border to give margins between edges of panel and where component
//will be placed
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
//Default tempo is '1.0' so on clicking Tempo Up button the tempo increases
//by 3% per click
        upTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
//Here tempo will decrease by 3% per click    
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
//This border on each instrument name/label helps them line up with checkboxes      
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            nameBox.add(instrumentLabel);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

//A layout manager that allows for components to be in a grid with rows and cols    
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);

        JPanel mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

//Make checkboxes, set them to false initially then add them to ArrayList and
//to the GUI panel
        checkboxList = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }//close builGUI() method

//Method to setup the Midi Event  
    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildTrackAndStart() {
//16-element array will be made to hold values for one instrument across
//all 16beats. i.e. if instrument is supposed to play on a specific beat, the
//value at that element will be the key. If not, we put in a zero
        int[] trackList;

//Remove the old track then create a new one   
        sequence.deleteTrack(track);
        track = sequence.createTrack();

//For each of the 16rows/instruments, we add an int array to hold 
//16 elements/beats    
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

//Set the key which represents that instrument. The instruments array holds
//the actual Midi numbers for each instrument
            int key = instruments[i];

//Do this for each of the beats/checkboxes for this row      
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxList.get(j + 16 * i);
//If checkbox is selected for an instrument, put the key value in slot in the 
//array that represents the beat, otherwise set it to zero since the instrument
//is not supposed to play at that beat i.e.unchecked
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }

            }
//For the current instrument and for all 16 beats, make events and add them
//to the track
            makeTracks(trackList);
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        }

//Always make that there is an event at beat 16 (goes 0 to 15), otherwise
//the beatbox might not go to the full 16 beats before it starts over
        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
//Specify the number of loop iterations, here it's continuous looping      
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
//Plays the song      
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//Tempo Factor scales the sequencers tempo by the factor provided by
//slowing the beat down or speeding it up (here it was 3%)
    private void changeTempo(float tempoMultiplier) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }

//Makes event for one instrument at a time for all 16 beats. So it might get
//an int[] for an instrument and each index in array will hold either the key
//of that instrument or a zero. So it makes an event for each key that should
//play at a particular and adds it to the track  
    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

//Makes the NOTE_ON and NOTE_OFF events and adds them to the track      
            if (key != 0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i + 1));
            }
        }
    }

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

}
