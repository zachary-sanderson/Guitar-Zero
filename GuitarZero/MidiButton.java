import java.io.File;
import javax.sound.midi.*;
import java.io.IOException;
import java.util.*;

/**
 * Convert MIDI file to button sequence.
 *
 * @author Blake Major
 * @version 1.00, 22 February 2019.
 */

public class MidiButton {
    final static String FILE = "Fur Elise.mid" ;

    static class Channel {
        int channel;
        int count;

        public Channel(int channel, int count) {
            this.channel = channel;
            this.count   = count;
        }
    }
    static class Button {
        long tick;
        int button;
        Boolean state;

        public Button(long tick, int note, Boolean state){
            this.tick  = tick;
            this.button  = note;
            this.state = state;
        }
    }

    /**
     * Returns button representation of nth note
     *
     * @param n note number
     * @return button
    */
    public static int noteToButton( int n ) {
        final int[] BUTTONS =
                { 1, 2, 3, 4, 5, 6};
        final int button   = (n % 12)/2;
        return BUTTONS[ button ];
    }

    /**
     * Get button sequence from an instrument channel
     *
     * @param trks the MIDI track array
     * @param channel theinstrment number
     * @return buton sequence
     */
    public static List<Button> buttonSequence(Track[] trks, int channel){
        List<Button> notes = new ArrayList<Button>();
        for ( int i = 0; i < trks.length; i++ ) {
            for (int j = 0; j < trks[i].size(); j++) {

                MidiEvent evt   = trks[i].get(j);
                MidiMessage msg = evt.getMessage();

                if (msg instanceof ShortMessage) {
                    final long tick         = evt.getTick();
                    final ShortMessage smsg = (ShortMessage) msg;
                    final int chan          = smsg.getChannel();
                    final int cmd           = smsg.getCommand();
                    final int dat1          = smsg.getData1();

                    if (chan == channel) {
                        switch (cmd) {
                            case ShortMessage.NOTE_ON:
                                int note = noteToButton(dat1);
                                Button button = new Button(tick, note, true);
                                notes.add(button);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    return notes;
    }

    /**
     * Returns the number of the channel with the most NOTE_ON events.
     *
     * @param trks array of MIDI tracks
     * @return  the channel number
     */
    public static int maxChannel(Track[] trks) {
        List<Channel> channels = new ArrayList<Channel>();
        List<Button> notes = new ArrayList<Button>();
        for (int i = 0; i < trks.length; i++) {
            for (int j = 0; j < trks[i].size(); j++) {
                MidiEvent evt = trks[i].get(j);
                MidiMessage msg = evt.getMessage();
                if (msg instanceof ShortMessage) {
                    final ShortMessage smsg = (ShortMessage) msg;
                    final int chan = smsg.getChannel();
                    final int cmd = smsg.getCommand();
                    switch (cmd) {
                        case ShortMessage.NOTE_ON:
                            if (channels.isEmpty()) {
                                Channel channel = new Channel(chan, 0);
                                channels.add(channel);
                            }
                            boolean checker = false;
                            for (Channel c : channels) {
                                if (c.channel == chan) {
                                    c.count++;
                                    checker = true;
                                }
                            }
                            if (checker == false) {
                                Channel channel = new Channel(chan, 1);
                                channels.add(channel);
                            }
                            break;
                    }
                }
            }
        }
        Channel mostNotes = channels.get(0);
        for(Channel c: channels){
            // channel 10 is for percusive instruments and would likely have most notes played, therefore we discount this channel.
            if(c.count > mostNotes.count & (c.channel != 10)){
                mostNotes = c;
            }
        }
        return mostNotes.channel;
    }

    /**
     * Returns representative GZ guitar button sequence for leading instrument in a MIDI file.
     *
     * @param file name of MIDI file
     * @return buttonSequence
     * @throws InvalidMidiDataException
     * @throws IOException
     */
    public static List<Button> midiToButton(String file) throws InvalidMidiDataException, IOException {
            Sequence seq = MidiSystem.getSequence( new File( FILE ) );
            Track trks[] = seq.getTracks();
            int channel  = maxChannel(trks);
            List<Button> buttonSequence = buttonSequence(trks, channel);
            return buttonSequence;

    }

    public static void main(String[] args){
        try{
            List<Button> buttons = midiToButton(FILE);
            for(Button b: buttons){
                System.out.println("tick: " + b.tick + "  button: " + b.button);
            }
        } catch(Exception exn) {
            System.out.println("Error in processing " + FILE);
        }
    }
}
