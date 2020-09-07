# OnSavedStateSample

## Android 상태 저장
### 1. 상태 저장이 필요한 이유

Android에서는 메모리 부족이나 다양한 이유로 인해 Android OS에서 Activity를 종료할 수 있다.
그 중에서 화면 회전을 할 경우 Activity를 종료 & 재생성하는데 
Activity의 상태를 저장하지 않을 경우 화면 회전 할 때마다 항상 새로 생성된 화면이 노출된다.

### *2. 하지 말아야 할 것*

+ android:configChanges   
가장 일반적인 솔루션으로 아래와 같이 AndroidManifest.xml의 Activity에 android:configChanges 플래그를 설정하여 처리하지 않는 것인데
```
<activity
    android:name=".MyActivity"
    android:label="@string/title_my_activity"
    android:configChanges="orientation|screenSize|keyboardHidden" />
```
&nbsp;&nbsp;&nbsp;이 설정은 Activity 종료 & 재생성을 하지 않는 대신 onConfigurationChanged 해당 함수를 호출하는데   
&nbsp;&nbsp;&nbsp;Fragment가 있는 경우 onConfigurationChanged 메서드에 대한 호출도 수신하나.   
&nbsp;&nbsp;&nbsp;이는 Activity 및 Fragment가 동일한 인스턴스가 사용되며 멤버 변수는 그대로 유지됨을 의미한다.   
      
&nbsp;&nbsp;&nbsp;만약 새 레이아웃을 사용하는 것과 같이 방향이 변경 될 때 뭔가 달라지기를 원한다면 onConfigurationChanged를 구현하고   
&nbsp;&nbsp;&nbsp;수동으로 이전 레이아웃 / 뷰를 삭제하고 새 레이아웃을 확장 한 다음 표시해야한다.   
&nbsp;&nbsp;&nbsp;이는 훨씬 더 많은 작업과 앞으로 코드 작업을 어렵게 만들 수 있다.   

+ Fragment.setRetainInstance(true)
해당 설정은 android:configChanges와 유사한데 Android에 현재 Fragment의 동일한 인스턴스를 계속 사용하고 싶다는 신호를 보내므로 모든 멤버 변수는 그대로 유지된다.
이 설정은 AsyncTask와 같은 동작(다운로드)에서 화면 회전 시 Activity가 종료 & 재생성되더라도 Fragment는 계속 사용하는 용도로 사용할 수 있다.

+ android:screenOrientation
이렇게 하면 사용자가 플래그가 설정된 활동에 있는 동안 방향 변경이 발생하지 않고 기기를 회전하면 화면도 함께 회전하지 않는다. 이것이 바람직한 동작 인 상황이 분명히 존재하지만 가능하면 앱의 유용성을 크게 향상 시키므로 앱을 가로 및 세로 방향으로 모두 사용할 수 있도록 허용해야 한다.

### 3. 상태 저장 방법
* 기본 적인 방법 (onSaveInstanceState)
* ViewModel
* SavedState + ViewModel

이와 같은 방법들을 Sample Project를 통해 정리한다.


## 참고자료
* [Android Developers ~ Activity](https://developer.android.com/reference/android/app/Activity, "Android Developer Activity Link")
* [Android Developers ~ Saving UI State](https://developer.android.com/topic/libraries/architecture/saving-states, "Android Developer Saving UI State Link")
* [Android Developers ~ Saved State module for ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel-savedstate, "Android Developer Saving UI State Link")
