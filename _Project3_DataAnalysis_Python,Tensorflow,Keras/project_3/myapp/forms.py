from django import forms
from .models import Post

class PostForm(forms.ModelForm):
    class Meta:
        model = Post
        #fields = ('image', 'text', 'tag',)
        fields = ('image', )
# class UploadFileForm(forms.ModelForm):
#     class Meta:
#         model = UploadFileModel
#         fields = ('title', 'file')
#  
#     def __init__(self, *args, **kwargs):
#         super(PostForm, self).__init__(*args, **kwargs)
#         self.fields['file'].required = False