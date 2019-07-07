package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.free.Main;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AsyncTest {

    private String joke;


        @Test
        public void testDoInBackground() throws Exception {
            Main fragment = new Main();
            fragment.testFlag = true;
            new AsyncClass().execute((Runnable) fragment);
            Thread.sleep(5000);
            assertTrue("Error: Fetched Joke = " + fragment.loadedJoke, fragment.loadedJoke != null);

        }
    }

