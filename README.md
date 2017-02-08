# EmotionKeyboard
仿微信具有表情输入、拍照上传的键盘

![01](https://github.com/KaneShaw/EmotionKeyboard/raw/master/displayPics/01.jpg)
![02](https://github.com/KaneShaw/EmotionKeyboard/raw/master/displayPics/02.jpg)
![03](https://github.com/KaneShaw/EmotionKeyboard/raw/master/displayPics/03.jpg)
![04](https://github.com/KaneShaw/EmotionKeyboard/raw/master/displayPics/04.jpg)

### Download	
Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency
	
	dependencies {
		compile 'com.github.KaneShaw:EmotionKeyboard:1.0.0'
	}
		
### Usage
	EmotionKeyboard emotionKeyboard = EmotionKeyboard.with(this) //初始化配置		
			.setExtendView(extendView) //设置扩展视图（自定义功能：拍照上传、位置等）		
			.setEmotionView(emotionView) //设置表情视图（自定义添加表情）			
			.bindToContent(contentView) //绑定内容视图		
			.bindToEditText(edittext) //绑定输入框		
			.bindToExtendbutton(extendButton) //绑定扩展视图按钮		
			.bindToEmotionButton(emotionButton) //绑定表情视图按钮			
			.build(); //创建
			
### Notice
最好加上如下代码保证物理返回键的正常使用

	public boolean interceptBackPress() {
        	if (mEmotionLayout.isShown()) {
            		hideLayout(mEmotionLayout, false);
            		return true;
        	}
        	return false;
   	 }
	 
注意：具体使用方法请参照demo

### Views Instruction
![05](https://github.com/KaneShaw/EmotionKeyboard/raw/master/displayPics/05.jpg)
![06](https://github.com/KaneShaw/EmotionKeyboard/raw/master/displayPics/06.jpg)
