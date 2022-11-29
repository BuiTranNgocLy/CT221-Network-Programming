# 1. Truyền thông
- Sự giao tiếp trao đổi thông tin
- Máy tính: Sự giao tiếp bên trong 1 quá trình hay giữa các quá trình với nhau
  - Hệ thống đơn nhiệm (monotasking): `1 chương trình`, biến toàn cục, tham số gọi hàm,..
  - Hệ thống đa nhiệm (multitasking): `thực thi song song`, `IPC`
## Cơ chế giao tiếp liên quá trinh (IPC)
- `Loại 1`: giao tiếp các quá trình / 1 máy

![image](https://user-images.githubusercontent.com/88178841/183802108-744eef8d-0cf0-47a1-8565-ee76e06f7dc5.png)
  - Thông qua hạt nhân (kernel)
  - Dùng chung vùng nhớ: ` 1 process đọc, 1 process ghi`
- `Loại 2`: nhiều quá trình / nhiều máy

![image](https://user-images.githubusercontent.com/88178841/183803263-505e7e09-2238-4b3d-9c16-8b0a4cfa7b2c.png)
- Thông qua hạt nhân (kernel)
- Phải có `quy tắc trao đổi thông tin (protocol)`
- 1 số IPC phổ biến: Pipe, Socket, RPC,..

# 2. Mô hình OSI

![image](https://user-images.githubusercontent.com/88178841/183804072-6c969ebe-1f26-48ce-b359-42e214346a11.png)
- Kiến trúc các hệ điều hành mạng:

![image](https://user-images.githubusercontent.com/88178841/183810278-798a8dce-9fba-4769-b9f3-223ee63c37ea.png)
`Cùng chức năng, không tương tác`

# 3. Mạng TCP/IP
- Giao thức chung để giao tiếp trên Internet
- Dùng OSI `5 tầng`

![image](https://user-images.githubusercontent.com/88178841/183813127-e42edc45-7b44-47ec-98ce-c972b288cf42.png)

- Bộ giao thức TCP/IP:

![image](https://user-images.githubusercontent.com/88178841/204540176-db68debd-2fcf-4b14-922a-37f28b06b3f2.png)
# 4.Dịch vụ mạng
- `Net service`: chương trình ứng dụng thực hiện 1 tác vụ nào đó trên hệ thống mạng.
- Mô hình cơ bản xây dựng dịch vụ mạng `Client - Server`
# 5. Mô hình Client - server
![image](https://user-images.githubusercontent.com/88178841/204542324-6bd224e9-db8f-4340-b585-04232b19c83c.png)
- `Client`: tạo ra yêu cầu -> gửi yêu cầu qua server -> chờ server xử lí -> nhận kết quả, xử lí theo mục riêng
- `Server`: lắng nghe yêu cầu -> nhận yêu cầu -> xử lí yêu cầu -> gửi kết quả client
- `Giao thức thông điệp tùy vào protocol của dịch vụ`
## Mô hình client-server của dịch vụ web:
![image](https://user-images.githubusercontent.com/88178841/204543489-6f3c3494-3a69-48ec-af80-b2e4269c289a.png)
## Các chế độ giao tiếp: `nghẽn` & `không nghẽn`
![image](https://user-images.githubusercontent.com/88178841/204543929-bdcf63a5-48cd-41e8-9cbc-0bf34fe1d497.png)

