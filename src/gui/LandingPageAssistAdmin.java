/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javax.swing.*;
import gui.utils.*;
import types.*;

/**
 *
 * @author Normal
 */
public class LandingPageAssistAdmin extends JPanel {
    private AssistantAdmin a;

    /**
     * Creates new form LandingPageAssistAdmin1
     */
    public LandingPageAssistAdmin(AssistantAdmin a) {
	this.a = a;

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tasks_panel = new JPanel();
        course_management_button = new JButton();

        tasks_panel.setBorder(BorderFactory.createTitledBorder("Tasks"));

        course_management_button.setText("Course Management");
        course_management_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_management_buttonActionPerformed(evt);
            }
        });

        GroupLayout tasks_panelLayout = new GroupLayout(tasks_panel);
        tasks_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(
            tasks_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, tasks_panelLayout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(course_management_button, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        tasks_panelLayout.setVerticalGroup(
            tasks_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tasks_panelLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(course_management_button)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tasks_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(tasks_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void course_management_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_management_buttonActionPerformed
        GUIUtils.getMasterFrame(this).movePage(new CreateCourse());
    }//GEN-LAST:event_course_management_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton course_management_button;
    private JPanel tasks_panel;
    // End of variables declaration//GEN-END:variables
}
