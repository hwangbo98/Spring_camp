### README

# 코멘토 Statistic API

## API Endpoints

### 1. 연별 로그인 접속수 조회

- **URL**: `/api/v1/logins/{year}`
- **Method**: GET
- **Path Variables**:
  - `year`: 요청 대상 연도 (예: `2020`)
- **Response Body**:
  ```json
  {
      "year": "2020",
      "totalAccessCount": 100
  }
  ```

### 2. 년월별 로그인 접속수 조회

- **URL**: `/api/v1/logins/{year}/{month}`
- **Method**: GET
- **Path Variables**:
  - `year`: 요청 대상 연도 (예: `2020`)
  - `month`: 요청 대상 월 (예: `08`)
- **Response Body**:
  ```json
  {
      "yearMonth": "202008",
      "totalAccessCount": 50
  }
  ```

### 3. 부서별 사용자 수 조회

- **URL**: `/api/v1/departments/userCounts`
- **Method**: GET
- **Query Parameters**:
  - `department` (optional): 부서 코드 (예: `HR1`)
- **Response Body**:
  ```json
  [
      {
          "department": "HR1",
          "userCount": 10
      },
      {
          "department": "HR2",
          "userCount": 12
      }
  ]
  ```

### 4. 부서별 로그인 수 조회

- **URL**: `/api/v1/departments/loginCounts`
- **Method**: GET
- **Query Parameters**:
  - `department` (optional): 부서 코드 (예: `HR1`)
- **Response Body**:
  ```json
  [
      {
          "department": "HR1",
          "loginCount": 100
      },
      {
          "department": "HR2",
          "loginCount": 80
      }
  ]
  ```

### 5. 년월별 게시글 작성수 조회

- **URL**: `/api/v1/posts/yearMonthCounts`
- **Method**: GET
- **Query Parameters**:
  - `yearMonth` (optional): 요청 대상 연월 (예: `202008`)
- **Response Body**:
  ```json
  [
      {
          "yearMonth": "202008",
          "postCount": 25
      },
      {
          "yearMonth": "202009",
          "postCount": 30
      }
  ]
  ```

### 6. 부서별 게시글 작성수 조회

- **URL**: `/api/v1/departments/postCounts`
- **Method**: GET
- **Query Parameters**:
  - `department` (optional): 부서 코드 (예: `HR1`)
- **Response Body**:
  ```json
  [
      {
          "department": "HR1",
          "postCount": 15
      },
      {
          "department": "HR2",
          "postCount": 20
      }
  ]
  ```

### 7. 평균 하루 로그인 수 조회

- **URL**: `/api/v1/logins/averageDaily`
- **Method**: GET
- **Response Body**:
  ```json
  {
      "averageDailyLogins": 45.5
  }
  ```

### 8. 공휴일 로그인 수 조회

- **URL**: `/api/v1/logins/holiday/{year}`
- **Method**: GET
- **Path Variables**:
  - `year`: 요청 대상 연도 (예: `2021`)
- **Response Body**:
  ```json
  [
      {
          "year": "2021-01-01",
          "totalAccessCount": 5
      },
      {
          "year": "2021-03-01",
          "totalAccessCount": 3
      }
  ]
  ```

### 9. 주말과 공휴일을 제외한 로그인 수 조회

- **URL**: `/api/v1/logins/nonHoliday/{year}`
- **Method**: GET
- **Path Variables**:
  - `year`: 요청 대상 연도 (예: `2021`)
- **Response Body**:
  ```json
  [
      {
          "year": "2021-01-04",
          "totalAccessCount": 10
      },
      {
          "year": "2021-01-05",
          "totalAccessCount": 15
      }
  ]
  ```

