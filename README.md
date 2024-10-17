# 직원관리 프로그램

### 메뉴화면 구성
1. 직원 정보 입력(이름, 나이, 직급, 부서, 급여)
2. 직원 전체 목록 조회
3. 직원 정보 검색
4. 직원 정보 삭제 및 수정
5. 부서별 직원 목록 조회


### 전체적인 프로젝트 구조
- controller
- data
- main
- repository
- util
- view

# 프로젝트 클래스 정의

### Controller
- controller -> 프로그램 상태에 따라 분기하는 클래스

### data
- EmployeeData -> 데이터 값을 담을 클래스

### main
- main -> 메인 클래스

### repository
- EmployeeRepository -> 데이터를 처리하는 클래스

### util
- Util -> .dat 파일로 저장하고 불러오는 클래스
- Values -> 분기하는 변수를 정의하는 클래스

### view
- DeleteEmployeeInfoView -> 직원 정보 삭제
- DeleteEmployeeTypeView -> 직원 부서 삭제
- ExitProgramView -> 프로그램 종료
- InputEmployeeInfoView -> 직원 정보 입력
- InputEmployeeTypeView -> 직원 부서 입력
- SearchEmployeeInfoView -> 직원 검색
- ShowAllEmployeeInfoView -> 전체 직원 정보 조회
- ShowMainMenuView -> 메인메뉴 
- ViewClass -> ..
- ListOfEmployeeType -> 부서별 직원 목록 조회


### 최종 결과
Data 파일에 저장 및 수정하고
프로그램이 종료할 때 .dat 파일로 저장하고  다시 프로그램이 시작될때
.dat 파일을 불러와서 data 파일에 불러온다.


