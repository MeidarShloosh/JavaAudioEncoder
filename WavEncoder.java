import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class WavEncoder {

    public static void encode(byte[] i_Payload, int i_SampleRate, int i_NumOfChannels, OutputStream i_OutputStream) throws IOException {

        AudioFormat frmt = new AudioFormat(i_SampleRate, 8, i_NumOfChannels, true, true);
        AudioInputStream ais = new AudioInputStream(
                new ByteArrayInputStream(i_Payload), frmt,
                (i_Payload.length  / 2 ) / frmt.getFrameSize()
        );

        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, i_OutputStream);

    }
}
