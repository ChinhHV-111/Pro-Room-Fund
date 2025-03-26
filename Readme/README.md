### ProRoomFund
---
#### Mô tả

ProHostel là ứng dụng quản lý quỹ phòng trọ giúp người dùng có thể lưu lại cách file minh chứng, tính toán quỹ phòng trong thời gian tuỳ chọn và lưu lại lịch sử.

#### Tác giả
- **Hoàng Văn Chính**

---
#### 📚 Nội dung
- [ProRoomFund](#proroomfund)
  - [Mô tả](#mô-tả)
  - [Tác giả](#tác-giả)
  - [📚 Nội dung](#-nội-dung)
  - [1. Cấu trúc thư mục](#1-cấu-trúc-thư-mục)
  - [2. Tính năng](#2-tính-năng)
  - [3. Ảnh chụp màn hình](#3-ảnh-chụp-màn-hình)
    - [a. SignIn](#a-signin)
    - [b. Room](#b-room)
    - [c. Member](#c-member)
    - [d. Expenditure](#d-expenditure)
    - [e. History](#e-history)
  - [4. Video demo sản phẩm](#4-video-demo-sản-phẩm)
  - [5. Môi trường](#5-môi-trường)
  - [6. Cài đặt dự án](#6-cài-đặt-dự-án)
---
#### 1. Cấu trúc thư mục
    Pro-Room-Fund/
    ├── src
    |    └── main
    |        ├── java
    |        |    ├── Controller
    |        |    |   ├── ExpenditureManager.java
    |        |    |   ├── HistoryManager.java
    |        |    |   ├── RoomManager.java
    |        |    |   ├── SignIn.java
    |        |    |   ├── SignUp.java
    |        |    ├── Model
    |        |    |   ├── FileData
    |        |    |   |    ├── Account.txt
    |        |    |   |    ├── Username.dat
    |        |    |   ├── Account.java
    |        |    |   ├── AccountDAO.java
    |        |    |   ├── Expenditure.java
    |        |    |   ├── Expense.java
    |        |    |   ├── Member.java
    |        |    |   ├── Room.java
    |        |    ├── Utility
    |        |    |   ├── AddExpenseStatus.java
    |        |    |   ├── ImageProcessor.java
    |        |    |   ├── SceneManager.java
    |        |    |   ├── SignUpStatus.java
    |        |    ├── Utility
    |        |    |   ├── AddExpenseView.java
    |        |    |   ├── AddMemberView.java
    |        |    |   ├── CalculateResultView.java
    |        |    |   ├── ExpenditureView.java
    |        |    |   ├── HistoryView.java
    |        |    |   ├── Main.java
    |        |    |   ├── MemberView.java
    |        |    |   ├── OpenProofView.java
    |        |    |   ├── OpenresultView.java
    |        |    |   ├── RoomEditView.java
    |        |    |   ├── RoomView.java
    |        |    |   ├── SignInView.java
    |        |    |   ├── SignUpView.java
    |        └── resources
    |            ├── FXML
    |            |   ├── ExpenditureView
    |            |   |   ├── AddExpenditure.css
    |            |   |   ├── AddExpenditure.fxml
    |            |   |   ├── CalculateResult.css
    |            |   |   ├── CalculateResult.fxml
    |            |   |   ├── ExpenditureView.css
    |            |   |   ├── ExpenditureView.fxml
    |            |   ├── HistoryView
    |            |   |   ├── HistoryView.css
    |            |   |   ├── HistoryView.fxml
    |            |   |   ├── OpenResultView.fxml
    |            |   ├── MemberView
    |            |   |   ├── AddMemberView.css
    |            |   |   ├── AddMemberView.fxml
    |            |   |   ├── MemberView.css
    |            |   |   ├── MemberView.fxml
    |            |   ├── RoomView
    |            |   |   ├── RoomEditView.fxml
    |            |   |   ├── RoomView.css
    |            |   |   ├── RoomView.fxml
    |            |   ├── SignInView
    |            |   |   ├── SignIn.css
    |            |   |   ├── SignIn.fxml
    |            |   ├── SignUpView
    |            |   |   ├── SignUp.css
    |            |   |   ├── SignUp.fxml
    └──          └── Image

#### 2. Tính năng
- Chỉnh sửa phòng
- Member
  - Add member
  - Delete member
- Expenditure
  - Add expense: có thể lựa chọn có minh chứng hoặc không minh chứng, nếu lựa chọn có minh chứng thì ảnh sẽ được clone vào folder user_image
  - Delete expense
  - Calculate: nếu save thì sẽ đẩy expenditure vào history, còn nếu cancel thì sẽ giữ nguyên expenditure cũ
- History
  - View button: xem lại kết quả tính toán
  - Delete: xoá lịch sử nếu không còn cần thiết
#### 3. Ảnh chụp màn hình
##### a. SignIn

![alt text](<Image/1. SignIn.png>)

##### b. Room

![alt text](<Image/2. Room.png>)

##### c. Member

![alt text](<Image/3. Member.png>)

##### d. Expenditure

![alt text](<Image/4. Expenditure.png>)

##### e. History

![alt text](<Image/5. History.png>)

#### 4. Video demo sản phẩm
https://www.youtube.com/watch?v=75qOLPOVmVE

#### 5. Môi trường
- Inteliji
- Ngôn ngữ: JavaFX
- Công cụ hỗ trợ: Scene Builder
#### 6. Cài đặt dự án
- Clone dự án
- Mở terminal và chạy lệnh: mvn clean install
- Hoặc sử dụng inteliji
- Chạy ứng dụng