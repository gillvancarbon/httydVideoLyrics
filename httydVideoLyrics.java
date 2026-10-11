import javax.sound.sampled.*;
import java.io.File;

public class httydVideoLyrics {

    // Text color
    static final String CYAN = "\u001B[96m";
    static final String WHITE = "\u001B[97m";

    // Text styles
    static final String BOLD = "\u001B[1m";
    static final String ITALIC = "\u001B[3m";
    
    // Converts seconds to milliseconds
    static final int SECOND_TO_MILLISECOND = 1000;

    // Plays the music file
    static Clip playMusic(String filePath)
            throws Exception {

        File file = new File(filePath);

        AudioInputStream audioStream =
                AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();

        try {
            clip.open(audioStream);
        } finally {
            audioStream.close();
        }

        clip.start();

        return clip;
    }

    // Pauses execution for the specified number of seconds
    static void pause(double stopTime)
            throws InterruptedException {

        Thread.sleep(
            (long) (stopTime * SECOND_TO_MILLISECOND)
        );
    }

    // Prints each character individually
    static void print(String text, int speed)
            throws InterruptedException {

        for (int i = 0; i < text.length(); i++) {

            System.out.print(text.charAt(i));

            Thread.sleep(speed);
        }
    }

    // Prints a lyric line with styling and a pause
    static void lyrics(
            String text,
            int speed,
            double pause,
            String style)
            throws InterruptedException {

        System.out.print(style + BOLD + ITALIC);

        print(text, speed);

        System.out.println();

        pause(pause);
    }

    // Intro
    static void intro()
            throws InterruptedException {

        lyrics(
            "Nostalgia playing".toUpperCase(),
            150,
            17.8,
            CYAN
        );

        System.out.println();
    }

    public static void main(String[] args)
            throws Exception {

        // Start the music
        Clip music = playMusic("music_pcm.wav");

        intro();

        lyrics(
            "Let the wind carry us",
            60,
            0.3,
            CYAN
        );

        lyrics(
            "To the clouds, hurry up, alright",
            70,
            3,
            CYAN
        );

        System.out.println();

        lyrics(
            "We can travel so far",
            80,
            0.2,
            CYAN
        );

        lyrics(
            "As our eyes can see",
            105,
            3,
            CYAN
        );

        System.out.println();

        lyrics(
            "We go where no one goes",
            190,
            2.6,
            CYAN
        );

        lyrics(
            "We slow for no one",
            180,
            0.5,
            CYAN
        );

        lyrics(
            "Get out of our way...",
            210,
            10.9,
            CYAN
        );

        System.out.println();

        lyrics(
            "What do you think bud?",
            30,
            1.2,
            WHITE
        );

        lyrics(
            "You wanna give this another shot?",
            35,
            1.5,
            WHITE
        );

        System.out.println();

        lyrics(
            "Toothless",
            65,
            0.4,
            WHITE
        );

        lyrics(
            "It'll be fine",
            50,
            3.7,
            WHITE
        );

        lyrics(
            "Ready?",
            50,
            3.5,
            WHITE
        );

        System.out.println();

        lyrics(
            "Awake in the sky",
            60,
            0.5,
            CYAN
        );

        lyrics(
            "We break up so high, alright",
            80,
            3.1,
            CYAN
        );

        System.out.println();

        lyrics(
            "Let's make it our own,",
            65,
            0.2,
            CYAN
        );

        lyrics(
            "Let's savor it",
            110,
            3.2,
            CYAN
        );

        System.out.println();

        lyrics(
            "We go where no one goes",
            190,
            1,
            CYAN
        );

        lyrics(
            "We slow",
            90,
            1.3,
            CYAN
        );

        System.out.println();

        lyrics(
            "For no one",
            150,
            3,
            CYAN
        );

        lyrics(
            "Get out of our way...",
            180,
            13,
            CYAN
        );

        // Stop and release the audio
        music.stop();
        music.close();
    }
}