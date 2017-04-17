# SimpleRecyclerView
只带加载更多功能的简单RecyclerView,其他使用与RecyclerView无异。

Only with a simple RecyclerView that loads more features, and the other uses the same as RecyclerView.

用法：

Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:
  gradle:
  allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
    
  or maven：
  <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  

Step 2. Add the dependency
  gradle:
  dependencies {
      compile 'com.github.User:Repo:Tag'
    }
  
  or maven:
  <dependency>
	    <groupId>com.github.User</groupId>
	    <artifactId>Repo</artifactId>
	    <version>Tag</version>
	</dependency>
  
  
