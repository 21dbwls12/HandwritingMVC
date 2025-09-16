# 필기앱(MVC)

## 📆 개발 기간

2025.02.07 ~ 2025.09.04

## 📝 소개

MVC 패턴과 MVP 패턴을 비교하여 학습하기 위한 프로젝트 중 하나이며, 이 앱은 MVC 패턴을 사용하여 만든 어플입니다.  

전에 진행했던 프로젝트 중 전자서명을 하는 화면에서 드래그 이후 획이 화면에 나타나지 않는 오류를 수정하지 못하고 프로젝트가 마무리된 적이 있습니다.
그래서 그 때, 그 부분이 아쉽고, 왜 구현되지 못했는지 궁금해서 해당 기능을 직접 구현해보고 싶었던 것도 있고 MLKit의 Ink를 사용해 보고 싶었기에 주제를 필기로 선정하게 되었습니다.  

원하는 이미지를 업로드 하여 화면에 표시할 수 있고, 사용자가 화면을 드래그하여 필기할 수 있도록 만들었습니다.

## ⚙️ 기술 스택

### 📱 App

- <img src="https://img.shields.io/badge/Android Studio-3DDC84?style=plastic&logo=androidstudio&logoColor=white">  <img src="https://img.shields.io/badge/Jetpack Compose-4285F4?style=plastic&logo=jetpackcompose&logoColor=white">
- <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=plastic&logo=kotlin&logoColor=white">
- <img src="https://img.shields.io/badge/Material Design 3-6750A4?style=plastic&logo=materialdesign&logoColor=white">
- <img src="https://img.shields.io/badge/Coil-3B6BB4?style=plastic">


### 🛠️ Tools

[![My Skills](https://skillicons.dev/icons?i=github,notion&theme=light)](https://skillicons.dev)

### 📷 화면 구성

![Screenshot_20250905_014543_HandwritingMVC](https://github.com/user-attachments/assets/575b0c27-068d-4272-abc6-8895bc88f312)|![Screenshot_20250905_014612_HandwritingMVC](https://github.com/user-attachments/assets/978258ae-d15a-42dc-993d-d13046531626)|![Screenshot_20250905_015123_HandwritingMVC](https://github.com/user-attachments/assets/cf313209-0c9d-45b5-9eb2-eb853a9c6e45)|
|:---:|:---:|:---:|
|가장 처음 화면|업로드 한 이미지|"MVC" 단어를 필기한 화면|
![Screenshot_20250905_015128_HandwritingMVC](https://github.com/user-attachments/assets/5f2ebb5d-a544-4a6c-89c4-33a3036f0ba0)|![Screenshot_20250905_015231_HandwritingMVC](https://github.com/user-attachments/assets/6f0ee938-cc85-49f6-a4e3-922288853ecc)|![Screenshot_20250905_015247_HandwritingMVC](https://github.com/user-attachments/assets/f6292e94-9974-49ee-9fc9-9fa14c4212c4)|
|상단에 휴지통 버튼을 누르면 나타나는 대화상자|대화상자의 "아니오" 버튼을 누른 화면|대화상자의 "예"를 누른 화면|
![Screen_Recording_20250905_015111_HandwritingMVC_1](https://github.com/user-attachments/assets/7aa23732-6c83-47ee-b8b2-3604c4fdd9be)|
|필기중인 화면|

### 🎥 시연 영상


https://github.com/user-attachments/assets/7d4b8def-a1c6-4a09-9346-e23eba21dff1

https://github.com/user-attachments/assets/0931489f-b39c-4980-8bae-6d120ed0f57d

## 📌 더 개선해야하는 점

- 저장 기능
  - 필기된 화면을 해당 부분만(업로드한 이미지 포함) 캡처하여 파일로 저장하는 기능 추가하고 싶습니다.
  - 더 추가할 수 있다면 확장자를 구분하여 저장할 수 있도록 하고 싶습니다.
    - pdf, png, jpg 등
- 파일 자체를 업로드 하는 기능을 추가하고 싶습니다.
  - pdf
  - 현재는 사진 선택 도구를 사용하여 업로드 기능을 구현했습니다.
- 획의 크기과 색상을 사용자가 변경하여 필기할 수 있도록 하고 싶습니다.
- Model의 데이터가 변경될 때 Controller가 인지하여 해당 데이터를 View로 보내주도록 수정하고 싶습니다.
  - 현재는 Model의 데이터가 변경되는 코드 밑에 Controller가 View로 넘겨줄 데이터를 변경된 Model의 데이터로 변경하는 코드를 직접 작성되어있습니다.
    - Model의 데이터를 직접 사용하는 것이라기 보다는 단순히 형식적인 기능에 그친다고 느껴 수정이 필요하다고 생각했습니다.


## ❗️ 배운 점

- MVC 패턴 개념에 대해 학습하였습니다.
  - Model(데이터), View(UI 및 UI 관련 코드), Controller(기능 구현 코드)
- 주석의 중요성을 인지하였습니다.
  - 크게 이미지 업로드 및 상단바(`Scaffold`) 구현과 필기 기능 구현으로 나누어 개발하였는데 필기 기능 구현 중 막히는 부분을 꽤 오래 시간 동안 해결하지 못하여서 시간이 많이 지난 후에 마무리 할 수 있었습니다. 그래서 삭제 관련 코드를 작업할 때 앞부분을 다시 건들어야 했는데 주석이 빈약해서 해당 부분을 찾거나 특정 코드의 작성 이유를 한눈에 알아보지 못했고 주석의 필요성을 알게되었습니다.
- `.value`의 사용 방법을 경험하며 학습하였습니다.
  - `LiveData`로 포장되어 있는 데이터에 접근할 때 `.value` 사용하면 된다는 것을 알게 되었고, 이를 통해 `.value`의 개념을 이해하였습니다.
- `pointerInteropFilter`메서드와 `pointerInput` 메서드를 통해 화면을 드래그하여 그림을 그리거나 글씨를 쓰는 기능을 구현하고 학습했습니다.
  - `pointerInterFilter`
    - `MotionEvent`와 MLKit의 `Ink`를 사용하여 구현했습니다.
    - 드래그 하는 동안 해당 획이 실시간으로 화면에 표시되지 않는 문제가 생겼습니다.
  - `pointerInput`
    - `Pair<Path, DrawStyle>`를 사용하여 구현했습니다.
    - 드래그 하는 동안 실시간으로 화면에 표시 되지 않는 문제를 이 메서드를 통해 해결했습니다.

## ❓ 궁금증

- MVC의 경계가 모호하다고 느꼈습니다. 코드를 작성할 수록 해당 코드가 어느 부분으로 들어가야하는지 헷갈리기도 하고, 이 패턴에 맞추려면 복잡해지는 것을 느꼈습니다. 이후에 이 패턴에 대한 공부가 필요성을 인지했습니다.
- 현재 코드 중 필기 기능을 구현할 때 새로 입력된 `path`를 임시 공간에 원래 저장되어 있는 `path`와 합쳐서 새로운 리스트를 만든 다음 이전 `path가 저장되어 있는 변수에 리스트 자체를 바꿔서 저장하여 화면에 표시하고 있는데 이게 효율적인지에 대해 의문을 가졌습니다.
  - 필기가 적다면 문제가 없겠지만 필기가 많아지거나 지금은 획의 크기나 색깔을 지정해두었지만 다양하게 필기할 수 있도록 설정해 놓으면 예상치 못한 오류나 렉이 걸릴 수 있지 않을까? 하는 고민이 생겼습니다.
  - 지금은 필기를 적고 간단하게 시연하는 것에 그치기 때문에 신경쓰지 않았지만 필기가 많아졌을 때의 상황을 미리 고민하고 만약 그런 상황이 생겨도 어플이 문제없이 실행될 수 있도록 작업해야하는 지, 그렇지 않다면 어디까지 생각해야할 지에 대해 고민이 생겼습니다.
- 현재 작업한 `Scaffold` 코드 내에서 `modifier` 안에 들어있는 메서드 `pointerInput`의 내부 인자들을 View가 아닌 Controller에서 입력값을 처리하도록 작성하였는데 그것에 대해 고민했습니다.
  - UI 관련 코드긴 하지만 입력값을 처리하는 코드라고 생각해서 Controller에서 실행하도록 작업하였습니다.
  - 해당 코드에 대해 검색해보았을 때, 다른 분들이 작성한 코드에서는 따로 함수로 빼내지 않고 UI 관련 코드에서 그대로 작성하신 것을 확인했습니다.
  - `pointerInput`만이 아니라 다른 인자들도 마찬가지로 View에서 실행시키도록 하는 게 맞는 것인지와 그 이유가 궁금합니다. MVC 패턴을 더 공부하여 완전히 이해하고 나면 알 수 있을 듯합니다.


