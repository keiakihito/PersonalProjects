import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# Load the CSV file into a DataFrame
filePath = "/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case5/Case5_ErrorAnalysis.csv"

data = pd.read_csv(filePath)

# Extract the required columns
# algo1: NewtonMethod
# algo2: BroydenMethod with Identity matrix
# algo3: BroydenMethod with Jacobean matrix

colVecNumOfIteration = data.iloc[:, 0]   # All dara of row, Column 1
colVecAlgo1 = data.iloc[:, 1]  # All dara of row, Column 2
colVecAlgo2 = data.iloc[:, 2]  # All dara of row, Column 3
# colVecAlgo3 = data.iloc[:, 3]  # All dara of row, Column 4


# Create the plot
plt.figure(figsize=(10, 10))

# Plot Algorithm 1 in red
plt.plot(colVecNumOfIteration, colVecAlgo1, 'ro-', label='Algorithm1 (Steepest Decent)', markersize=8, markerfacecolor='red')

# Plot Algorithm 2 in blue
plt.plot(colVecNumOfIteration, colVecAlgo2, 'bo-', label='Algorithm2 (Conjugate Gradient)', markersize=8, markerfacecolor='blue')

# # Plot Algorithm 3 in green
# plt.plot(colVecNumOfIteration, colVecAlgo3, 'g-', label='Algorithm3 (BroydenMethod with Jacobean Matrix)', markersize=8, markerfacecolor='green')

# Customize the plot
plt.xlabel('# of iteration')
plt.ylabel('Absolute error |λ_i - λ_(i-1)|')

plt.title('Plot of error per iteration for1024 by 1024 symmetric matrix with v = [1,1...1]')

plt.legend()

plt.yscale('log', base=2)
plt.xlim(0, 60)
# # For zoom in
# plt.xlim(0, 100)

legend_labels = ['Algorithm1 (Steepest Decent)', 'Algorithm2 (Conjugate Gradient)']

legend_colors = ['red', 'blue']
legend_patches = [plt.Line2D([0], [0], marker='o', color='w', label=label, markersize=8, markerfacecolor=color) for label, color in zip(legend_labels, legend_colors)]
plt.legend(handles=legend_patches)

# Show the plot
plt.grid()

# Save the plot as a PDF file
plt.savefig('/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case5/Case5_ErrorAnalysis.pdf', format='pdf')
# plt.savefig('plot_error_ngt_zoom.pdf', format='pdf')

plt.show()