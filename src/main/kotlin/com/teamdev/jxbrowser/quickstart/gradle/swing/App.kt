/*
 *  Copyright 2025, TeamDev. All rights reserved.
 *
 *  Redistribution and use in source and/or binary forms, with or without
 *  modification, must retain the above copyright notice and the following
 *  disclaimer.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.teamdev.jxbrowser.quickstart.gradle.swing

import com.teamdev.jxbrowser.dsl.Engine
import com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED
import com.teamdev.jxbrowser.view.swing.BrowserView
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.SwingUtilities

/**
 * This example demonstrates how to initialize Chromium, create a browser instance
 * (equivalent of the Chromium tab), embed a Swing BrowserView component into Java Swing
 * frame to display content of the loaded web page, load the required web page.
 */
fun main() {
    // Initialize Chromium.
    val engine = Engine(HARDWARE_ACCELERATED)

    // Create a Browser instance.
    val browser = engine.newBrowser()

    SwingUtilities.invokeLater {
        JFrame("JxBrowser Swing").apply {
            // Shutdown Chromium and release allocated resources when the frame closes.
            addWindowListener(object : WindowAdapter() {
                override fun windowClosing(e: WindowEvent) {
                    engine.close()
                }
            })
            // Create and embed Swing BrowserView component to display web content.
            add(BrowserView.newInstance(browser))
            setSize(1280, 800)
            setLocationRelativeTo(null)
            isVisible = true
        }

        // Load the required web page.
        browser.navigation().loadUrl("https://html5test.teamdev.com/")
    }
}
