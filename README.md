# CS470FinalProject_CarRentalManagementSystem
To run this system from the administrative side, please run the main method of AdminMainGUI.java, and to run this system from the user (customer) side, please run the main method of EnterUserGUI.java.

The system already has a limited number of cars, bookings and requests already loaded, however any creation or destruction of these objects is saved in txt files contained in bin/src when the user closes the MainGUI for either the administrative side or the customer side.

When moving between windows, any time the user closes a GUI they are taken back to the previous window, and this functions as the back button for all GUIs. Closing out either MainGUI class (or EnterUserGUI) will save any changes to inventory, confirmed bookings and booking requests and terminate the program.

At almost all points there is only one GUI active to prevent potential issues of concurrency. Once again, you can always go back by simply closing out the window.

If there are any issues with running the program on your device (perhaps my Eclipse setup was doing something behind the scenes that I didn't account for) please let me know and I will try to correct the issue.
