# ContactHub

For this project I was looking for a way to remind myself to reach out to family, friends, coworkers etc.  The main idea of the project was that a user would be able to create a contact and add numerous details such as date of birth, address, their likes and dislikes, random notes about their contact and more. Users can reference these notes to stay updated on personal details like "remember to ask about how their play went" or "ask how their job interview went". Additionally, users can view a contact’s likes or dislikes to help with gift ideas for birthdays or holidays.

## Project specs
To further develop my skills, I built ContactHub using Spring Boot for the backend, React for the frontend, and PostgreSQL for data storage. The app is hosted on AWS EC2 and uses Amazon RDS for the PostgreSQL database. Profile pictures are stored in AWS S3.

## YouTube Demo
Demo of the project can be seen here(coming soon). 

## Road Map and features to be implemented.
- Implement **Uppy** for image uploads to enhance the user experience.
- Add a text message reminder feature using **Twilio**, **Amazon SNS**, or similar services. This feature will notify users if they haven't reached out to a contact in a while or remind them to follow up on important events (like a play or job interview).
- Email notifications when a birthday is coming up, including their likes and dislikes.
- A page to restore deleted contacts and permanently delete them.
- Additional user interface improvements for better visuals.

