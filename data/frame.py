import sys
import os

def new_frame(text):
    sys.stdout.write('\r' + text)
    sys.stdout.flush()


def clear_frame():
    os.system('cls' if os.name == 'nt' else 'clear')


def progress(num):
    step = 1
    perc = '%7.3f%%' % (num * 100)
    bar = int(num * 100 / step)
    space = int(100 / step) - bar
    sys.stdout.write('\r[' + ('=' * bar) + (' ' * space) + '] ' + perc)