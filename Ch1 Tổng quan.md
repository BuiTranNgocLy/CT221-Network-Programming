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

