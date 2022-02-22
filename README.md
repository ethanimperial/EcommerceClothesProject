# EcommerceClothesProject

READ ME TO START APPLICATION


CLONING THE APPLICATION

1. First copy the url link by selecting the dropdown code button and copy the HTTPS link
2. Run Eclipse IDE on local device
3. Direct to 'Git Repositories' and select 'Clone a Git Repository'
4. Input the HTTPS link in the URI and your github username and passsword
5. Ensure all the branches are selected before selecting finish
6. After cloning the repository go to your package explorer
7. Click on 'Import Project -> Existing Maven Project -> Choose the cloned repository'
8. Once this is completed, you should be on the master branch and have successfully cloned the repository


TO RUN THE APPLICATION

1. Go to 'Window -> Show View'
2. Search for 'Servers' in the search bar
3. Ensure that you have either Tomcat 8.0 or 9.0 is installed on your local device
4. Right click on the project and select on 'Run as -> Run on server'
5. Select the Tomcat server and click on finish
6. Ensure you have Apache and MySQL running on XAMPP
7. Right click on the Tomcat server in the servers panel and click on 'start'
8. Input the following url into your web browser: "http://localhost:8090/EcommerceClothesProject/login.jsp"


*SOME NOTES TO TAKE*

Please ensure your port number on your eclipse workspace is the same as the URL's. To change the port number,
Click on the Tomcat server and under ports, ammend the 'HTTP/1.1' port number

When making edits to the project, it is highly recommmended to not make changes to the master branch as it could lead to team conflicts.
On your Eclipse Workspace, right click your project and select 'Team -> Switch To -> New Branch' to create a new branch.
Make your ammended edits on the newly created branch.
