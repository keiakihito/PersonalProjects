import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# Load the CSV file into a DataFrame
filePath = "/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ExecutionTimeAve/Case3/Case3_AveTimes.csv"
data = pd.read_csv(filePath)

# Extract the required columns
# algo1: Steepest Decent method 
# algo2: Conjugate Gradient
# algo3: QR Factorization

colVecNumOfProbSize = data.iloc[:, 0]   # All dara of row, Column 1
colVecAlgo1 = data.iloc[:, 1]  # All dara of row, Column 2
colVecAlgo2 = data.iloc[:, 2]  # All dara of row, Column 3
colVecAlgo3 = data.iloc[:, 3]  # All dara of row, Column 4


# Create the plot
plt.figure(figsize=(10, 10))

# Plot Algorithm 1 in red
plt.plot(colVecNumOfProbSize, colVecAlgo1, 'ro-', label='Algorithm1 (Steepest Decent)', markersize=8, markerfacecolor='red')

# Plot Algorithm 2 in blue
plt.plot(colVecNumOfProbSize, colVecAlgo2, 'bo-', label='Algorithm2 (Conjugate Gradient)', markersize=8, markerfacecolor='blue')

# Plot Algorithm 3 in green
plt.plot(colVecNumOfProbSize, colVecAlgo3, 'go-', label='Algorithm3 (QR Factorization)', markersize=8, markerfacecolor='green')

# Customize the plot
plt.xlabel('# of Problem size')
plt.ylabel('Time of Execution (millisecond)')

plt.title('Plot of 100 times average execution time millisecond second (ms)  (ex. second = 1000 ms; minutes = 60000 ms) ')

plt.legend()

plt.xscale('log', base=2)
plt.yscale('log', base=2)

legend_labels = ['Algorithm1 (Steepest Decent)', 'Algorithm2 (Conjugate Gradient)', 'Algorithm3 (QR Factorization)']

legend_colors = ['red', 'blue', 'green']
legend_patches = [plt.Line2D([0], [0], marker='o', color='w', label=label, markersize=8, markerfacecolor=color) for label, color in zip(legend_labels, legend_colors)]
plt.legend(handles=legend_patches)

# Show the plot
plt.grid()

# Save the plot as a PDF file
plt.savefig('/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ExecutionTimeAve/Case3/Case3_AveTimesPlot.pdf', format='pdf')

plt.show()