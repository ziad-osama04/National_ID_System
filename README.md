# Egyptian National ID Management System

## 📋 Overview
A comprehensive Java application designed to manage Egyptian National IDs, featuring automated ID generation that follows official government formatting rules. The system provides a user-friendly GUI interface using JOptionPane for data management and validation.

## 🔑 Key Features
- **Automated ID Generation**
  - Smart 13-digit ID creation
  - Follows official Egyptian ID format
  - Incorporates date, gender, and governorate codes
  - Validates against future dates

- **Data Management**
  - Create new user records
  - Edit existing information
  - Display all users
  - Search functionality
  - Data validation checks

- **Smart Validation System**
  - Address length verification
  - Date validation
  - Governorate code mapping
  - Gender-based ID number assignment

- **User Interface**
  - Interactive GUI using JOptionPane
  - Clear menu navigation
  - User-friendly input forms
  - Comprehensive data display

## 🛠️ Technical Implementation
- **Programming Language:** Java
- **GUI Framework:** Swing (JOptionPane)
- **Data Structures:** ArrayList, List
- **Date Handling:** LocalDate
- **Input Validation:** Custom validation logic

## 📊 Class Structure
1. **Team5.java (Main Class)**
   - Program entry point
   - Menu handling
   - User interaction flow

2. **Data_Read.java**
   - Data collection
   - Validation logic
   - ID generation
   - Governorate code mapping

3. **Id_Class.java**
   - Data model
   - Getter/Setter methods
   - Date handling
   - ID storage

## 💻 Usage
1. Run the application
2. Choose from menu options:
   - Add User
   - Edit User
   - Display All Users
   - Exit

## 🔍 ID Generation Logic
- Prefix based on birth year (2/3)
- Year, month, day components
- Governorate code (01-35)
- Gender identifier (1/2)
- Random sequence number

## ⚙️ System Requirements
- Java Runtime Environment (JRE)
- Minimum Java Version: 8
- GUI-capable system

## 🚀 Getting Started
```bash
# Clone the repository
git clone https://github.com/Anas-Mohamed-Abdelghany/Egyptian-ID-System.git

# Navigate to project directory
cd Egyptian-ID-System

# Compile the project
javac *.java

# Run the application
java Team5
```

## 📝 Input Validation Rules
- Name: Required field
- Address: Minimum 6 characters
- Date: Must be valid and not in future
- Gender: Male/Female selection
- Religion: Muslim/Christian/Other
- Government: Valid Egyptian governorate

## 👥 Contributors
- Ziad Osama
- Hassan Badawy
- Nada Mostafa
- Saga Sadek
  
## 🔄 Future Improvements
- Database integration
- Export functionality
- Advanced search features
- Batch processing
- PDF generation for ID cards

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## 📞 Communicate
https://www.linkedin.com/in/anas-mohamed-716959313
