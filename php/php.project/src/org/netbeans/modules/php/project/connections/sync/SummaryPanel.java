/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.project.connections.sync;

import java.awt.Color;
import java.awt.Dialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

/**
 * Synchronization confirmation panel.
 */
public class SummaryPanel extends JPanel {

    private static final long serialVersionUID = 176831576846546L;

    private static final Logger LOGGER = Logger.getLogger(SummaryPanel.class.getName());


    public SummaryPanel(int uploadNumber, int downloadNumber, int deleteNumber, int noopNumber) {
        initComponents();
        setNumber(uploadNumberLabel, uploadNumber);
        setNumber(downloadNumberLabel, downloadNumber);
        setNumber(deleteNumberLabel, deleteNumber);
        setNumber(noopNumberLabel, noopNumber);
    }

    @NbBundle.Messages({
        "SummaryPanel.title=Summary",
        "SummaryPanel.button.titleWithMnemonics=S&ynchronize"
    })
    public boolean open() {
        assert SwingUtilities.isEventDispatchThread();
        JButton okButton = new JButton();
        Mnemonics.setLocalizedText(okButton, Bundle.SummaryPanel_button_titleWithMnemonics());
        DialogDescriptor descriptor = new DialogDescriptor(
                this,
                Bundle.SummaryPanel_title(),
                true,
                new Object[] {okButton, DialogDescriptor.CANCEL_OPTION},
                okButton,
                DialogDescriptor.DEFAULT_ALIGN,
                null,
                null);
        final Dialog dialog = DialogDisplayer.getDefault().createDialog(descriptor);
        try {
            dialog.setVisible(true);
        } finally {
            dialog.dispose();
        }
        return descriptor.getValue() == okButton;
    }

    public void uploadError() {
        setErrorComponents(uploadLabel, uploadNumberLabel);
    }

    public void downloadError() {
        setErrorComponents(downloadLabel, downloadNumberLabel);
    }

    public void deleteError() {
        setErrorComponents(deleteLabel, deleteNumberLabel);
    }

    public void decreaseUploadNumber() {
        decreaseNumber(uploadNumberLabel);
    }

    public void decreaseDownloadNumber() {
        decreaseNumber(downloadNumberLabel);
    }

    public void decreaseNoopNumber() {
        decreaseNumber(noopNumberLabel);
    }

    public void setDeleteNumber(int number) {
        setNumber(deleteNumberLabel, number);
    }

    private void setNumber(JLabel numberLabel, int number) {
        numberLabel.setText(String.valueOf(number));
    }

    @NbBundle.Messages("SummaryPanel.na=N/A")
    private void decreaseNumber(JLabel numberLabel) {
        try {
            int number = Integer.parseInt(numberLabel.getText());
            number--;
            numberLabel.setText(String.valueOf(number));
        } catch (NumberFormatException ex) {
            LOGGER.log(Level.WARNING, null, ex);
            numberLabel.setText(Bundle.SummaryPanel_na());
        }
    }

    private void setErrorComponents(JComponent... components) {
        for (JComponent component : components) {
            component.setForeground(getErrorColor());
        }
    }

    private Color getErrorColor() {
        return UIManager.getColor("nb.errorForeground"); // NOI18N
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uploadLabel = new JLabel();
        downloadLabel = new JLabel();
        deleteLabel = new JLabel();
        noopLabel = new JLabel();
        uploadNumberLabel = new JLabel();
        downloadNumberLabel = new JLabel();
        deleteNumberLabel = new JLabel();
        noopNumberLabel = new JLabel();
        Mnemonics.setLocalizedText(uploadLabel, NbBundle.getMessage(SummaryPanel.class, "SummaryPanel.uploadLabel.text")); // NOI18N
        Mnemonics.setLocalizedText(downloadLabel, NbBundle.getMessage(SummaryPanel.class, "SummaryPanel.downloadLabel.text")); // NOI18N
        Mnemonics.setLocalizedText(deleteLabel, NbBundle.getMessage(SummaryPanel.class, "SummaryPanel.deleteLabel.text")); // NOI18N
        Mnemonics.setLocalizedText(noopLabel, NbBundle.getMessage(SummaryPanel.class, "SummaryPanel.noopLabel.text")); // NOI18N
        Mnemonics.setLocalizedText(uploadNumberLabel, "0"); // NOI18N
        Mnemonics.setLocalizedText(downloadNumberLabel, "0"); // NOI18N
        Mnemonics.setLocalizedText(deleteNumberLabel, "0"); // NOI18N
        Mnemonics.setLocalizedText(noopNumberLabel, "0"); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addContainerGap()

                .addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                        .addComponent(downloadLabel)

                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(downloadNumberLabel)).addGroup(layout.createSequentialGroup()
                        .addComponent(uploadLabel)

                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(uploadNumberLabel)).addGroup(layout.createSequentialGroup()
                        .addComponent(deleteLabel)

                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(deleteNumberLabel)).addGroup(layout.createSequentialGroup()
                        .addComponent(noopLabel)

                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(noopNumberLabel))).addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addContainerGap()

                .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(uploadLabel).addComponent(uploadNumberLabel)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(downloadLabel).addComponent(downloadNumberLabel)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(deleteLabel).addComponent(deleteNumberLabel)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(noopLabel).addComponent(noopNumberLabel)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel deleteLabel;
    private JLabel deleteNumberLabel;
    private JLabel downloadLabel;
    private JLabel downloadNumberLabel;
    private JLabel noopLabel;
    private JLabel noopNumberLabel;
    private JLabel uploadLabel;
    private JLabel uploadNumberLabel;
    // End of variables declaration//GEN-END:variables
}
