# Contact Manager Application

A modern, full-stack contact management system built with Spring Boot (backend) and React (frontend).

## 🚀 Features

### ✅ Core Features (Implemented)

- **➕ Add New Contact**
  - Add contact details including name, phone number, and email
  - Form validation for required fields
  - Real-time data persistence

- **👀 View Contacts**
  - Display all saved contacts in a structured grid layout
  - Responsive design that works on desktop and mobile
  - Clean, modern UI with contact cards

- **❌ Delete Contact**
  - Remove contacts with confirmation dialog
  - Real-time updates after deletion

- **🔐 User Authentication (Login & Registration)**
  - Secure user registration and login system
  - Session management with localStorage
  - Protected routes - contacts only accessible when logged in

### 🎯 Planned Features (To Be Implemented)

- **✏️ Update / Edit Contact**
  - Modify existing contact information
  - Edit form with pre-filled data

- **🔍 Search Contacts**
  - Search contacts by name, phone number, or email
  - Real-time search with filtering

- **📂 Contact Categories / Groups**
  - Organize contacts into groups (Family, Friends, Work, etc.)
  - Category-based filtering and organization

- **⭐ Favorite Contacts**
  - Mark important contacts as favorites
  - Quick access to frequently contacted people

- **📄 Pagination**
  - Display contacts in pages for better performance
  - Load more functionality for large contact lists

- **🔃 Sorting Options**
  - Sort contacts alphabetically (A-Z, Z-A)
  - Sort by recently added contacts
  - Sort by contact type/category

- **📤 Export Contacts (CSV)**
  - Download contact list as CSV file
  - Bulk export functionality

- **📥 Import Contacts (CSV)**
  - Upload contacts from CSV file
  - Bulk import with validation

- **🖼 Contact Photo Upload**
  - Upload and display profile images for each contact
  - Image preview and management

- **🌙 Dark Mode Toggle**
  - Switch between light and dark themes
  - Theme persistence across sessions

- **✔️ Data Validation & Duplicate Detection**
  - Validate phone/email format
  - Prevent duplicate entries
  - Comprehensive form validation

## 🛠 Tech Stack

### Backend (Spring Boot)
- **Java 17**
- **Spring Boot 3.5.11**
- **Spring Data JPA**
- **H2 Database** (in-memory for development)
- **Spring Security** (for authentication - to be implemented)
- **REST API**

### Frontend (React)
- **React 18**
- **Axios** (HTTP client)
- **CSS3** (Styling)
- **Responsive Design**

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Node.js 16+
- Maven

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/mandalidedeepya22/TT_project.git
   cd contactmanager
   ```

2. **Backend Setup**
   ```bash
   # Navigate to project root
   cd contactmanager
   
   # Start Spring Boot backend
   ./mvnw spring-boot:run
   ```

3. **Frontend Setup**
   ```bash
   # Open new terminal
   cd frontend
   
   # Install dependencies
   npm install
   
   # Start React development server
   npm start
   ```

4. **Access the Application**
   - Backend API: `http://localhost:8080`
   - Frontend App: `http://localhost:3000`
   - H2 Console: `http://localhost:8080/h2-console`

### Default Admin Credentials
- **Username:** `admin`
- **Password:** `admin123`

## 📁 Project Structure

```
contactmanager/
├── src/main/java/com/example/contactmanager/
│   ├── ContactmanagerApplication.java          # Main application class
│   ├── config/
│   │   └── DataInitializer.java               # Database initialization
│   ├── controller/
│   │   ├── AuthController.java                # Authentication endpoints
│   │   └── ContactController.java             # Contact management endpoints
│   ├── model/
│   │   ├── Contact.java                       # Contact entity
│   │   └── User.java                          # User entity
│   ├── repository/
│   │   ├── ContactRepository.java             # Contact data access
│   │   └── UserRepository.java                # User data access
│   └── service/                               # Business logic (to be implemented)
├── frontend/
│   ├── public/
│   │   └── index.html                         # Main HTML file
│   ├── src/
│   │   ├── App.js                             # Main App component
│   │   ├── App.css                            # App styles
│   │   ├── services/
│   │   │   └── api.js                         # API service layer
│   │   └── components/
│   │       ├── SignIn.js                      # Authentication component
│   │       ├── SignIn.css                     # Authentication styles
│   │       ├── AddContact.js                  # Add contact component
│   │       ├── AddContact.css                 # Add contact styles
│   │       ├── ContactList.js                 # Contact list component
│   │       └── ContactList.css                # Contact list styles
│   └── package.json                           # Frontend dependencies
├── pom.xml                                    # Maven configuration
└── README.md                                  # This file
```

## 🔧 API Endpoints

### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration

### Contact Management
- `GET /api/contacts` - Get all contacts
- `POST /api/contacts` - Add new contact
- `DELETE /api/contacts/{id}` - Delete contact

## 🎨 Screenshots

*(Screenshots would be added here when available)*

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📋 TODO List

- [ ] Implement contact editing functionality
- [ ] Add search functionality
- [ ] Implement contact categories/groups
- [ ] Add favorite contacts feature
- [ ] Implement pagination
- [ ] Add sorting options
- [ ] Implement CSV export functionality
- [ ] Implement CSV import functionality
- [ ] Add contact photo upload
- [ ] Implement dark mode toggle
- [ ] Enhance data validation and duplicate detection
- [ ] Add unit and integration tests
- [ ] Implement proper authentication with JWT
- [ ] Add frontend routing for better UX
- [ ] Create comprehensive documentation

## 🐛 Bug Reports

Please report bugs by creating an issue with:
- Description of the bug
- Steps to reproduce
- Expected behavior
- Actual behavior
- Screenshots (if applicable)

## 💡 Feature Requests

We welcome feature requests! Please create an issue with:
- Clear description of the feature
- Use case explanation
- Any relevant mockups or examples

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Dedeepya Mandalidi** - Initial work

## 🙏 Acknowledgments

- Spring Boot community
- React community
- All open-source contributors whose work made this project possible

---

**Note:** This application is currently in development. Some features listed above are planned for future implementation.