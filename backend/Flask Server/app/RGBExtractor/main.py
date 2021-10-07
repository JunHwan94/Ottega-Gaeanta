import tkinter as tk
from tkinter import filedialog, Entry, StringVar, Canvas
from PIL import Image, ImageTk

r = g = b = 0


def get_color(event):
    global r, g, b
    r, g, b = px[event.x, event.y]
    var.set(f'RGB values  : ({r},{g},{b})')


root = tk.Tk()
root.title("Color Detector")

path = filedialog.askopenfilename()
try:
    var = StringVar()
    img = Image.open(path)
    img = img.resize((1000, 750), Image.ANTIALIAS)
    px = img.load()
    label = Entry(root, state='readonly', readonlybackground='white', fg='black', width=100, font='Helvetica 16 bold')
    label.config(textvariable=var, relief='flat')
    label.pack()
    canvas = Canvas(root, width=img.size[0], height=img.size[1])
    canvas.pack()
    image_tk = ImageTk.PhotoImage(img)
    canvas.create_image(img.size[0] // 2, img.size[1] // 2, image=image_tk)
    canvas.bind('<Button-1>', get_color)
except Exception:
    pass
root.mainloop()
