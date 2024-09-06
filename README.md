Developed an application that is capable of processing repository of videos, convert them to searchable hashtags using Optical Character Recognition (OCR).

- My application can handle two input cases - analyzing from an existing repository or getting a video from the user.
- It processes the input as a sequence of fast moving images. The number of frames per second would differ for every videos though the number of frames a human eye could interpret is only way lesser.
- Ultimately, there are plenty of OCR algorithms to extract text from meaningful number of images. We need to make sure that the number of images are input to the text extraction program and using Tesseract, we need to extract text.
- It is likely that the extracted text has more noise than the required information so it becomes imperative that an algorithm cleans the output text from Tesseract.
- The text is then processed, cleaned by removing unwanted stop words and we generate search tags (hashtags) for the video.
- The hashtags is filtered to represent the video which in turn helps the user to identify the content of the video without even playing it.
