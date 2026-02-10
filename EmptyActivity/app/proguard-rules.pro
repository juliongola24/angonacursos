# Add project specific ProGuard rules here.

# Keep Gson serialization
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.angonurse.anapp.data.** { *; }
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

# Keep Firebase
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Keep Material Components
-keep class com.google.android.material.** { *; }
-dontwarn com.google.android.material.**
